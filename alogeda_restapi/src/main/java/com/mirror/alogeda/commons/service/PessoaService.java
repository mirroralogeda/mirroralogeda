package com.mirror.alogeda.commons.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mirror.alogeda.commons.model.Pessoa;
import com.mirror.alogeda.commons.repository.PessoaRepository;

@Service
public class PessoaService extends CrudService<Pessoa> {
	private PessoaRepository pessoaRepository;

	@Autowired
	public PessoaService(PessoaRepository pessoaRepository) {
		this.pessoaRepository = pessoaRepository;
		setGenericRepository(pessoaRepository);
	}

	}
