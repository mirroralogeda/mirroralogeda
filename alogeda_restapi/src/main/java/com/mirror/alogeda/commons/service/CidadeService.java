package com.mirror.alogeda.commons.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mirror.alogeda.commons.model.Cidades;
import com.mirror.alogeda.commons.repository.CidadesRepository;

@Service
public class CidadeService extends CrudService<Cidades> {

	@Autowired
	public CidadeService(CidadesRepository cidadeRepository) {
		super(cidadeRepository);
	}

	}
