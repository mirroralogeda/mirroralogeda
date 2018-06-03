package com.mirror.alogeda.commons.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.mirror.alogeda.commons.model.Funcionarios;
import com.mirror.alogeda.commons.repository.FuncionariosRepository;

@Service
public class FuncionariosService extends CrudService<Funcionarios> {

	@Autowired
	public FuncionariosService(FuncionariosRepository Repository) {
		super(Repository);
	}
}
