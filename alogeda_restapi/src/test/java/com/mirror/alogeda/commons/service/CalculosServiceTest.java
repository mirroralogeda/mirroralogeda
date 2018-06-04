package com.mirror.alogeda.commons.service;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit4.SpringRunner;

import com.mirror.alogeda.commons.model.Eventos;
import com.mirror.alogeda.commons.model.Funcionarios;
import com.mirror.alogeda.commons.model.Salarios;
import com.mirror.alogeda.commons.repository.EventosRepository;
import com.mirror.alogeda.commons.repository.FuncionariosRepository;
import com.mirror.alogeda.commons.repository.SalariosRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
@ComponentScan(basePackages = "com.mirror.alogeda.commons.service")
public class CalculosServiceTest  {
@Autowired
private TestEntityManager entityManager;
@Autowired
private EventosRepository eveRepository;
@Autowired
private SalariosRepository salRepository;
@Autowired
private FuncionariosRepository funRepository;
@Autowired
private CalculosService calcService;

@Test
public void teste() {
	Funcionarios fun = new Funcionarios();
	funRepository.save(fun);

	Eventos eve = new Eventos();
	eve.setFormula("salario_base * 0.08");
	eveRepository.save(eve);

	Salarios sal = new Salarios();
	sal.setValor(2000D);
	sal.setVigInicial(new Date());
	sal.setFuncionarios(fun);
	salRepository.save(sal);

	calcService.Calcula();
}

}
