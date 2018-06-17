package com.mirror.alogeda.commons.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;
import com.mirror.alogeda.commons.model.Funcionarios;
import com.mirror.alogeda.commons.repository.FuncionariosRepository;

@Service
public class FuncionariosService extends CrudService<Funcionarios> {

	private FuncionariosRepository funcionariosRepositorio;
	@Autowired
	public FuncionariosService(FuncionariosRepository Repository) {
		super(Repository);
		this.funcionariosRepositorio = Repository;
	}
	public List<Funcionarios> findByName(String nome){
		
		return funcionariosRepositorio.findByName2(nome);
	}

	public Funcionarios buscaId (int id){
		return funcionariosRepositorio.buscaId(id).get(0);	
	}
}
