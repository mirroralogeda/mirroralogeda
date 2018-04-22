package com.mirror.alogeda.commons.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mirror.alogeda.commons.model.Endereco;
import com.mirror.alogeda.commons.repository.EnderecoRepository;

@Service
public class EnderecoService extends CrudService<Endereco> {
	private EnderecoRepository enderecoRepository;

	@Autowired
	public EnderecoService(EnderecoRepository enderecoRepository) {
		this.enderecoRepository = enderecoRepository;
		setGenericRepository(enderecoRepository);
	}

	}
