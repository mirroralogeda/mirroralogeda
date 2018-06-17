package com.mirror.alogeda.commons.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mirror.alogeda.commons.model.Atestados;
import com.mirror.alogeda.commons.model.Pessoas;
import com.mirror.alogeda.commons.repository.AtestadosRepository;
import com.mirror.alogeda.commons.repository.PessoasRepository;

@Service
public class PessoaService extends CrudService<Pessoas> {

	PessoasRepository pessoaRepository;
	@Autowired
	public PessoaService(PessoasRepository pessoaRepository) {
		super(pessoaRepository);
		this.pessoaRepository = pessoaRepository;
	}
    public Pessoas findByCpf(String cpf){
    	return pessoaRepository.findByCpfContaining(cpf);
    }

	
}
