package com.mirror.alogeda.commons.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mirror.alogeda.commons.model.Pessoas;
import com.mirror.alogeda.commons.repository.PessoasRepository;

@Service
public class PessoaService extends CrudService<Pessoas> {

	@Autowired
	public PessoaService(PessoasRepository pessoaRepository) {
		super(pessoaRepository);
	}

}
