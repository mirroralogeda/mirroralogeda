package com.mirror.alogeda.commons.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mirror.alogeda.commons.model.Calculos;
import com.mirror.alogeda.commons.model.Eventos;
import com.mirror.alogeda.commons.model.Salarios;
import com.mirror.alogeda.commons.model.TabInss;
import com.mirror.alogeda.commons.model.TabSalFamilia;
import com.mirror.alogeda.commons.repository.EventosRepository;
import com.mirror.alogeda.commons.repository.SalariosRepository;
import com.mirror.alogeda.commons.repository.TabInssRepository;
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


	public List<Calculos> Calcula() {
		List<Calculos> calcs = new ArrayList<Calculos>();
		Calculadora calculadora = new Calculadora(tabInssRepo.findByPerFinalIsNull(), tabSalRepo.findByPerFinalIsNull());

		// Cada funcionario tem um salario, logo iterando pelos salarios vigentes tambem
		// se itera pelos funcionarios.
		for (Salarios sal : salRepo.findByVigFinalIsNull()) {
			for (Eventos eve : eveRepo.findAll()) {
				double valor = 0;
				valor += calculadora.eval(eve.getFormula(), sal);

				if (eve.getValorMaximo() != null && eve.getValorMaximo() != 0 && valor >= eve.getValorMaximo())
					valor = eve.getValorMaximo();
				else if (eve.getValorMinimo() != null && eve.getValorMinimo() != 0 && valor <= eve.getValorMinimo())
					valor = eve.getValorMinimo();

				// Assume para o tipo: 1 = neutro, 2 = provento e 3 = desconto
				// Nota, mudar para enum assim que possivel
				//				switch (eve.getTipo()) {
				/*
				case 1:
					neutros += calculadora.eval(eve.getFormula(), sal);
					break;
				case 2:
					descontos += calculadora.eval(eve.getFormula(), sal);
					break;
				case 3:
					proventos += calculadora.eval(eve.getFormula(), sal);
					break;
				default:
					break;
				}
				*/

				Calculos calc = new Calculos();
				calc.setDataCalculo(new Date());
				calc.setFuncionarios(sal.getFuncionarios());
				calc.setEventos(eve);
				calc.setValor(valor);
				calcs.add(calc);
			}
		}

		return calcs;
	}


private class Calculadora{
	private List<TabInss> tabInss;
	private List<TabSalFamilia> tabSalFamilia;
	private final String SALARIO_BASE = "salario_base";

	// Nomes das ariaveis disponiveis
	// Alternativas: vir do banco, ser array de enum normal, ou enum com Bit Flags
	private final String[] variaveis = new String[] { SALARIO_BASE };

	// O construtor recebe objetos que tem potencial de serem usados em varios calculos.
	public Calculadora(List<TabInss> tabInss, List<TabSalFamilia> tabSalFamilia) {
		this.tabInss = tabInss;
		this.tabSalFamilia = tabSalFamilia;
		this.tabInss.sort((t1, t2) -> t1.getValInicial().compareTo(t2.getValInicial()));
		this.tabSalFamilia.sort((t1, t2) -> t1.getValInicial().compareTo(t2.getValInicial()));
	}

	public double eval(String expr, Salarios sal) {
		String[] vars = getVars(expr);
		Map<String, BigDecimal> varVals = getValoresVariaveiss(vars, sal);

		Expression e = new Expression(expr);

		for (String v : vars)
			e = e.setVariable(v, varVals.get(v));

		for (Function f : getFuncoes())
			e.addFunction(f);

		return e.eval().doubleValue();
	}

	private Function[] getFuncoes() {
return new Function[] { getFuncTabInss(), getFuncTabSalFamilia() };
	}

	// Retorna os nomes das variaveis contidas nas formulas
	public String[] getVars(String expr) {
		List<String> vars = new ArrayList<String>();

		for (String v : variaveis)
			if (expr.contains(v))
				vars.add(v);

		return vars.toArray(new String[vars.size()]);
	}

	public Map<String, BigDecimal> getValoresVariaveiss(String[] vars, Salarios sal) {
		Map<String, BigDecimal> varVals = new HashMap<String, BigDecimal>();

		for (String v : vars) {
			switch (v) {
			case SALARIO_BASE:
				varVals.put(SALARIO_BASE, new BigDecimal(sal.getValor()));
				break;
			default:
				break;
			}
		}

		return varVals;
	}

	public Function getFuncTabInss() {
		return new AbstractFunction("tab_inss", 1) {

		    @Override
		    public BigDecimal eval(List<BigDecimal> args) {
		    	BigDecimal val = args.get(0);
		    	Optional<TabInss> faixa = tabInss.stream().filter(f -> val.compareTo(new BigDecimal(f.getValInicial())) >= 0 && val.compareTo(new BigDecimal(f.getValFinal())) <= 0).findFirst();

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
	    	Optional<TabSalFamilia> faixa = tabSalFamilia.stream().filter(f -> val.compareTo(new BigDecimal(f.getValInicial())) >= 0 && val.compareTo(new BigDecimal(f.getValFinal())) <= 0).findFirst();

	    	if (faixa.isPresent())
	    		return new BigDecimal(faixa.get().getValor());

	    	return BigDecimal.ZERO;
	    }
	};
	}
}

}
