package com.mirror.alogeda.commons.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mirror.alogeda.commons.model.Calculos;
import com.mirror.alogeda.commons.model.Dependentes;
import com.mirror.alogeda.commons.model.Eventos;
import com.mirror.alogeda.commons.model.Salarios;
import com.mirror.alogeda.commons.model.TabInss;
import com.mirror.alogeda.commons.model.TabIrrf;
import com.mirror.alogeda.commons.model.TabSalFamilia;
import com.mirror.alogeda.commons.repository.EventosRepository;
import com.mirror.alogeda.commons.repository.SalariosRepository;
import com.mirror.alogeda.commons.repository.TabInssRepository;
import com.mirror.alogeda.commons.repository.TabIrrfRepository;
import com.mirror.alogeda.commons.repository.TabSalFamiliaRepository;
import com.udojava.evalex.AbstractFunction;
import com.udojava.evalex.Expression;
import com.udojava.evalex.Function;

@Service
public class CalculosService {
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
		List<Calculos> calcs = new ArrayList<Calculos>();

		// Cada funcionario tem um salario, logo iterando pelos salarios vigentes tambem
		// se itera pelos funcionarios.
		for (Salarios sal : salRepo.findByVigFinalIsNull()) {
			Calculadora calculadora = new Calculadora(sal);

			for (Eventos eve : eveRepo.findAllByOrderByOrdemCalculoAsc()) {
				double valor = 0;
				valor += calculadora.eval(eve.getFormula(), eve);

				if (eve.getValorMaximo() != null && eve.getValorMaximo() != 0 && valor >= eve.getValorMaximo())
					valor = eve.getValorMaximo();
				else if (eve.getValorMinimo() != null && eve.getValorMinimo() != 0 && valor <= eve.getValorMinimo())
					valor = eve.getValorMinimo();

				Calculos calc = new Calculos();
				calc.setDataCalculo(new Date());
				calc.setFuncionarios(sal.getFuncionarios());
				calc.setEventos(eve);
				calc.setValor(valor);
				calc.setReferencia(eve.getReferencia());
				calcs.add(calc);
			}
		}

		return calcs;
	}

	private class Calculadora {
		private Salarios salario;
		private BigDecimal salarioAtual;
		private List<TabInss> tabInss;
		private List<TabSalFamilia> tabSalFamilia;
		private List<TabIrrf> tabIrrf;

		private static final String SALARIO_BASE = "salario_base";
		private static final String SALARIO_ATUAL = "salario_atual";
		private static final String DEPENDENTES_SAL_FAMILIA = "dependentes_sal_familia";
		private static final String DEPENDENTES_IRRF = "dependentes_irrf";

		// Nomes das ariaveis disponiveis
		// Alternativas: vir do banco, ser array de enum normal, ou enum com Bit Flags
		private final String[] variaveis = new String[] { SALARIO_BASE, SALARIO_ATUAL, DEPENDENTES_SAL_FAMILIA, DEPENDENTES_IRRF };

		public Calculadora(Salarios sal) {
			this.salario = sal;
			this.salarioAtual = new BigDecimal(salario.getValor());
			this.tabInss = tabInssRepo.findByVigencia(new Date());
			this.tabSalFamilia = tabSalRepo.findByVigencia(new Date());
			this.tabIrrf = tabIrrfRepo.findByVigencia(new Date());
		}

		public double getSalarioAtual() {
			return salarioAtual.doubleValue();
		}

		public double eval(String expr, Eventos eve) {
			expr = expr.replace(".", "").replace(",", ".");
			String[] vars = getVars(expr);
			Map<String, BigDecimal> varVals = getValoresVariaveiss(vars);

			Expression e = new Expression(expr);

			for (String v : vars)
				e = e.setVariable(v, varVals.get(v));

			for (Function f : getFuncoes())
				e.addFunction(f);

			e.setPrecision(2);
			BigDecimal res = e.eval();

			// Assume para o tipo: 1 = neutro, 2 = provento e 3 = desconto
			// Nota, mudar para enum assim que possivel
			if (eve.getTipo() == 2)
				salarioAtual = salarioAtual.add(res);
			else if (eve.getTipo() == 3)
				salarioAtual = salarioAtual.subtract(res);

			return res.doubleValue();
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

			for (String v : vars) {
				switch (v) {
				case SALARIO_BASE:
					varVals.put(SALARIO_BASE, new BigDecimal(salario.getValor()));
					break;
				case SALARIO_ATUAL:
					varVals.put(SALARIO_ATUAL, salarioAtual);
					break;
				case DEPENDENTES_SAL_FAMILIA:
					varVals.put(DEPENDENTES_SAL_FAMILIA, new BigDecimal(salario.getFuncionarios().getDependenteses().stream().filter(Dependentes::getSalarioFamilia).collect(Collectors.toList()).size()));
					break;
				case DEPENDENTES_IRRF:
					varVals.put(DEPENDENTES_IRRF, new BigDecimal(salario.getFuncionarios().getDependenteses().stream()
							.filter(Dependentes::getImpostoRenda).collect(Collectors.toList()).size()));
					break;
				default:
					break;
				}
			}

			return varVals;
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
