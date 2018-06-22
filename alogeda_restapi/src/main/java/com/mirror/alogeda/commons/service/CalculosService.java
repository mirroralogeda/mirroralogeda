package com.mirror.alogeda.commons.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import com.mirror.alogeda.commons.exceptions.DomainException;
import com.mirror.alogeda.commons.model.Calculos;
import com.mirror.alogeda.commons.model.Dependentes;
import com.mirror.alogeda.commons.model.Eventos;
import com.mirror.alogeda.commons.model.Funcionarios;
import com.mirror.alogeda.commons.model.ParametrosFolha;
import com.mirror.alogeda.commons.model.Salarios;
import com.mirror.alogeda.commons.model.TabInss;
import com.mirror.alogeda.commons.model.TabIrrf;
import com.mirror.alogeda.commons.model.TabSalFamilia;
import com.mirror.alogeda.commons.model.TipoEvento;
import com.mirror.alogeda.commons.model.viewmodel.CalculoFuncionario;
import com.mirror.alogeda.commons.model.viewmodel.CalculoPeriodo;
import com.mirror.alogeda.commons.model.viewmodel.PeriodoFolha;
import com.mirror.alogeda.commons.repository.CalculosRepository;
import com.mirror.alogeda.commons.repository.EventosRepository;
import com.mirror.alogeda.commons.repository.ParametrosFolhaRepository;
import com.mirror.alogeda.commons.repository.SalariosRepository;
import com.mirror.alogeda.commons.repository.TabInssRepository;
import com.mirror.alogeda.commons.repository.TabIrrfRepository;
import com.mirror.alogeda.commons.repository.TabSalFamiliaRepository;
import com.udojava.evalex.AbstractFunction;
import com.udojava.evalex.Expression;
import com.udojava.evalex.Function;

import org.javatuples.Pair;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CalculosService {
	@Autowired
	private CalculosRepository calcRepo;
	@Autowired
	private ParametrosFolhaRepository prfRepo;
	@Autowired
	private EventosRepository eveRepo;
	@Autowired
	private SalariosRepository salRepo;
	@Autowired
	private TabInssRepository tabInssRepo;
	@Autowired
	private TabSalFamiliaRepository tabSalRepo;
	@Autowired
	private TabIrrfRepository tabIrrfRepo;

	@Transactional
	public List<Calculos> Calcula() {
		List<ParametrosFolha> prfs = prfRepo.findByVigencia(new Date());

		if (prfs.size() == 0)
			throw new DomainException("Não há períodos abertos para a data atual.");

		return Calcula(prfs.get(0));
	}

	@Transactional
	public List<Calculos> Calcula(ParametrosFolha parametro) {
		Date dataCalculo = new Date();
		List<Calculos> calcs = new ArrayList<Calculos>();

		// Cada funcionario tem um salario, logo iterando pelos salarios vigentes tambem
		// se itera pelos funcionarios.
		for (Salarios sal : salRepo.findByVigFinalIsNull()) {
			Calculadora calculadora = new Calculadora(sal);

			for (Eventos eve : eveRepo.findAllByOrderByOrdemCalculoAsc()) {
				if (isEventoFixo(eve) && !isEventoFixoParaFuncionario(eve, sal.getFuncionarios()))
					continue;

				double valor = calculadora.eval(eve).doubleValue();

				if (eve.getValorMaximo() != null && eve.getValorMaximo() != 0 && valor >= eve.getValorMaximo())
					valor = eve.getValorMaximo();
				else if (eve.getValorMinimo() != null && eve.getValorMinimo() != 0 && valor <= eve.getValorMinimo())
					valor = eve.getValorMinimo();

				Calculos calc = new Calculos();
				calc.setDataCalculo(dataCalculo);
				calc.setPerIncial(parametro.getPerInicial());
				calc.setPerFinal(parametro.getPerFinal());
				calc.setFuncionarios(sal.getFuncionarios());
				calc.setEventos(eve);
				calc.setValor(valor);
				calcRepo.save(calc);
				calcs.add(calc);
			}
		}

		return calcs;
	}

	// Otimizar (criar consultas) assim que possivel
	public List<PeriodoFolha> getPeriodos() {
		List<PeriodoFolha> periodos = new ArrayList<>();
		List<Calculos> calcs = calcRepo.findAll();

		Map<Object, List<Calculos>> perCalcGrup = calcs.stream()
				.collect(Collectors.groupingBy(c -> new Pair<Date, Date>(c.getPerIncial(), c.getPerFinal())));

		HashSet<Pair<Date, Date>> periodosGrupo = new HashSet<Pair<Date, Date>>();
		for (Object o : perCalcGrup.keySet()) {
			List<Calculos> grupCalc = perCalcGrup.get(o);
			Pair<Date, Date> p = (Pair<Date, Date>) o;
			periodosGrupo.add(p);
			periodos.add(new PeriodoFolha(p.getValue0(), p.getValue1(),
					(int) grupCalc.stream().map(Calculos::getDataCalculo).distinct().count(),
					grupCalc.stream().anyMatch(c -> c.isPerFechado() != null && c.isPerFechado())));
		}

		Set<Pair<Date, Date>> periodosParametros = prfRepo.findAll().stream()
				.map(p -> new Pair<Date, Date>(p.getPerInicial(), p.getPerFinal())).collect(Collectors.toSet());
		periodosParametros.removeAll(periodosGrupo);

		for (Pair<Date, Date> p : periodosParametros)
			periodos.add(new PeriodoFolha(p.getValue0(), p.getValue1(), 0, false));

		return periodos;
	}

	public List<CalculoPeriodo> getCalculosPeriodo(ParametrosFolha parametro) {
		List<CalculoPeriodo> calcsPeriodo = new ArrayList<>();
		List<Calculos> calcs = calcRepo.findByDataCalculoBetween(parametro.getPerInicial(), parametro.getPerFinal());
		Map<Object, List<Calculos>> calcsDataGrupo = calcs.stream()
				.collect(Collectors.groupingBy(c -> c.getDataCalculo()));

		for (Object o : calcsDataGrupo.keySet()) {
			List<Calculos> calcsData = calcsDataGrupo.get(o);
			CalculoPeriodo calcPer = new CalculoPeriodo();
			calcPer.setDataCalculo((Date) o);
			calcPer.setFuncionarios((int) calcsData.stream().map(c -> c.getFuncionarios().getId()).distinct().count());
			calcPer.setFechamento(calcsData.stream().anyMatch(c -> c.isPerFechado() != null && c.isPerFechado()));
			calcsPeriodo.add(calcPer);
		}

		return calcsPeriodo;
	}

	public List<CalculoFuncionario> getFuncionariosCalculo(Date data) {
		return calcRepo.findByDataCalculo(data).stream().map(c -> new CalculoFuncionario(c.getFuncionarios()))
				.collect(Collectors.toList());
	}

	private boolean isEventoFixo(Eventos eve) {
		return eve.getEveFixoses().size() > 0;
	}

	private boolean isEventoFixoParaFuncionario(Eventos eve, Funcionarios fun) {
		Date dataAtual = new Date();
		return eve.getEveFixoses().stream()
				.filter(ef -> ef.getFuncionarios().getId() == fun.getId()
						&& dataAtual.compareTo(ef.getPerInicial()) >= 0 && dataAtual.compareTo(ef.getPerFinal()) <= 0)
				.findFirst().isPresent();
	}

	private class Calculadora {
		private Salarios salario;
		private BigDecimal salarioAtual;
		private List<TabInss> tabInss;
		private List<TabSalFamilia> tabSalFamilia;
		private List<TabIrrf> tabIrrf;
		private Map<Eventos, BigDecimal> eventosCalculados;

		private static final String SALARIO_BASE = "salario_base";
		private static final String SALARIO_ATUAL = "salario_atual";
		private static final String SALARIO_INCIDENCIA = "salario_incidencia";
		private static final String DEPENDENTES_SAL_FAMILIA = "dependentes_sal_familia";
		private static final String DEPENDENTES_IRRF = "dependentes_irrf";

		// Nomes das ariaveis disponiveis
		// Alternativas: vir do banco, ser array de enum normal, ou enum com Bit Flags
		private final String[] variaveis = new String[] { SALARIO_BASE, SALARIO_ATUAL, DEPENDENTES_SAL_FAMILIA,
				DEPENDENTES_IRRF };

		public Calculadora(Salarios sal) {
			this.salario = sal;
			this.salarioAtual = new BigDecimal(salario.getValor());
			this.tabInss = tabInssRepo.findByVigencia(new Date());
			this.tabSalFamilia = tabSalRepo.findByVigencia(new Date());
			this.tabIrrf = tabIrrfRepo.findByVigencia(new Date());
			this.eventosCalculados = new HashMap<Eventos, BigDecimal>();
		}

		public BigDecimal eval(Eventos eve) {
			if (eventosCalculados.containsKey(eve))
				return eventosCalculados.get(eve);

			BigDecimal salarioInc = new BigDecimal(salario.getValor());
			for (Eventos inc : eve.getIncidencias()) {
				if (inc.getTipo() == TipoEvento.PROVENTO)
					salarioInc = salarioInc.add(eval(inc));
				else if (inc.getTipo() == TipoEvento.DESCONTO)
					salarioInc = salarioInc.subtract(eval(inc));
			}

			String expr = eve.getFormula();
			expr = expr.replace(".", "").replace(",", ".");
			String[] vars = getVars(expr);
			Map<String, BigDecimal> varVals = getValoresVariaveiss(vars);

			Expression e = new Expression(expr);

			for (String v : vars)
				e = e.setVariable(v, varVals.get(v));

			if (expr.contains(SALARIO_INCIDENCIA))
				e = e.setVariable(SALARIO_INCIDENCIA, salarioInc);

			for (Function f : getFuncoes())
				e.addFunction(f);

			BigDecimal res = e.eval();
			eventosCalculados.put(eve, res);

			if (eve.getTipo() == TipoEvento.PROVENTO)
				salarioAtual = salarioAtual.add(res);
			else if (eve.getTipo() == TipoEvento.DESCONTO)
				salarioAtual = salarioAtual.subtract(res);

			return res;
		}

		// Retorna os nomes das variaveis contidas nas formulas
		public String[] getVars(String expr) {
			List<String> vars = new ArrayList<String>();

			for (String v : variaveis)
				if (expr.contains(v))
					vars.add(v);

			return vars.toArray(new String[vars.size()]);
		}

		public Map<String, BigDecimal> getValoresVariaveiss(String[] vars) {
			Map<String, BigDecimal> varVals = new HashMap<String, BigDecimal>();

			for (String v : vars)
				varVals.put(v, getValorVariavel(v));

			return varVals;
		}

		private BigDecimal getValorVariavel(String v) {
			switch (v) {
			case SALARIO_BASE:
				return new BigDecimal(salario.getValor());
			case SALARIO_ATUAL:
				return salarioAtual;
			case DEPENDENTES_SAL_FAMILIA:
				return new BigDecimal(salario.getFuncionarios().getDependenteses().stream()
						.filter(Dependentes::getSalarioFamilia).collect(Collectors.counting()).intValue());
			case DEPENDENTES_IRRF:
				return new BigDecimal(salario.getFuncionarios().getDependenteses().stream()
						.filter(Dependentes::getImpostoRenda).collect(Collectors.counting()).intValue());
			default:
				break;
			}

			throw new DomainException("Variável " + v + " não foi reconhecida.");
		}

		private Function[] getFuncoes() {
			return new Function[] { getFuncTabInss(), getFuncTabSalFamilia(), getFuncTabIrrf() };
		}

		public Function getFuncTabInss() {
			return new AbstractFunction("tab_inss", 1) {

				@Override
				public BigDecimal eval(List<BigDecimal> args) {
					BigDecimal val = args.get(0);
					Optional<TabInss> faixa = tabInss.stream()
							.filter(f -> val.compareTo(new BigDecimal(f.getValInicial())) >= 0
									&& val.compareTo(new BigDecimal(f.getValFinal())) <= 0)
							.findFirst();

					if (faixa.isPresent())
						return new BigDecimal(faixa.get().getPercentual());

					return new BigDecimal(tabInss.get(tabInss.size()).getPercentual());
				}
			};
		}

		public Function getFuncTabSalFamilia() {
			return new AbstractFunction("tab_sal_familia", 1) {

				@Override
				public BigDecimal eval(List<BigDecimal> args) {
					BigDecimal val = args.get(0);
					Optional<TabSalFamilia> faixa = tabSalFamilia.stream()
							.filter(f -> val.compareTo(new BigDecimal(f.getValInicial())) >= 0
									&& val.compareTo(new BigDecimal(f.getValFinal())) <= 0)
							.findFirst();

					if (faixa.isPresent())
						return new BigDecimal(faixa.get().getValor());

					return BigDecimal.ZERO;
				}
			};
		}

		public Function getFuncTabIrrf() {
			return new AbstractFunction("tab_irrf", 1) {

				@Override
				public BigDecimal eval(List<BigDecimal> args) {
					BigDecimal val = args.get(0);
					Optional<TabIrrf> faixa = tabIrrf.stream()
							.filter(f -> val.compareTo(new BigDecimal(f.getValInicial())) >= 0
									&& (f.getValFinal() == null || val.compareTo(new BigDecimal(f.getValFinal())) <= 0))
							.findFirst();

					if (faixa.isPresent())
						return val.multiply(new BigDecimal(faixa.get().getPercentual()))
								.subtract(new BigDecimal(faixa.get().getDeducao()));

					return BigDecimal.ZERO;
				}
			};
		}
	}

}
