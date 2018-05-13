package com.mirror.alogeda.commons.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mirror.alogeda.commons.model.Enderecos;
import com.mirror.alogeda.commons.repository.EnderecosRepository;

@Service
public class EnderecoService extends CrudService<Enderecos> {

	@Autowired
	public EnderecoService(EnderecosRepository enderecoRepository) {
				super(enderecoRepository);
	}

	}
