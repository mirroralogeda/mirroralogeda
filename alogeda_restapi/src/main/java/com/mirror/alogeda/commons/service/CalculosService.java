package com.mirror.alogeda.commons.service;

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
import com.mirror.alogeda.commons.repository.EventosRepository;
import com.mirror.alogeda.commons.repository.SalariosRepository;
import com.mirror.alogeda.commons.repository.TabInssRepository;

import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;
import net.objecthunter.exp4j.function.Function;

@Service
public class CalculosService {
	@Autowired
	private EventosRepository eveRepo;
	@Autowired
	private SalariosRepository salRepo;
	@Autowired
	private TabInssRepository tabInssRepo;


	public List<Calculos> Calcula() {
		List<Calculos> calcs = new ArrayList<Calculos>();
		Calculadora calculadora = new Calculadora(tabInssRepo.findByPerFinalIsNull());

		// Cada funcionario tem um salario, logo iterando pelos salarios vigentes tambem
		// se itera pelos funcionarios.
		for (Salarios sal : salRepo.findByVigFinalIsNull()) {
			for (Eventos eve : eveRepo.findAll()) {
				double valor = 0;
				valor += calculadora.eval(eve.getFormula(), sal);

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
	private final String SALARIO_BASE = "salario_base";

	// Nomes das ariaveis disponiveis
	// Alternativas: vir do banco, ser array de enum normal, ou enum com Bit Flags
	private final String[] variaveis = new String[] { SALARIO_BASE };

	// O construtor recebe objetos que tem potencial de serem usados em varios calculos.
	public Calculadora(List<TabInss> tabInss) {
		this.tabInss = tabInss;
		this.tabInss.sort((t1, t2) -> t1.getValInicial().compareTo(t2.getValInicial()));
	}

	public double eval(String expr, Salarios sal) {
		String[] vars = getVars(expr);
		Map<String, Double> varVals = getValoresVariaveiss(vars, sal);

		Expression e = new ExpressionBuilder(expr)
				.variables(vars)
				.functions(getFuncoes())
				.build();

		for (String v : vars)
			e = e.setVariable(v, varVals.get(v));

		return e.evaluate();
	}

	private Function[] getFuncoes() {
return new Function[] { getFuncTabInss() };
	}

	// Retorna os nomes das variaveis contidas nas formulas
	public String[] getVars(String expr) {
		List<String> vars = new ArrayList<String>();

		for (String v : variaveis)
			if (expr.contains(v))
				vars.add(v);

		return vars.toArray(new String[vars.size()]);
	}

	public Map<String, Double> getValoresVariaveiss(String[] vars, Salarios sal) {
		Map<String, Double> varVals = new HashMap<String, Double>();

		for (String v : vars) {
			switch (v) {
			case SALARIO_BASE:
				varVals.put(SALARIO_BASE, sal.getValor());
				break;
			default:
				break;
			}
		}

		return varVals;
	}

	public Function getFuncTabInss() {
		return new Function("tab_inss", 1) {

		    @Override
		    public double apply(double... args) {
		    	double val = args[0];
		    	Optional<TabInss> faixa = tabInss.stream().filter(f -> val >= f.getValInicial() && val <= f.getValFinal()).findFirst();

		    	if (faixa.isPresent())
		    		return faixa.get().getPercentual();

		    	return tabInss.get(tabInss.size()).getPercentual();
		    }
		};
		}
}

}
