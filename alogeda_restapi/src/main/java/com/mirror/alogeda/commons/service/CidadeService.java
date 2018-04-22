package com.mirror.alogeda.commons.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mirror.alogeda.commons.model.Cidade;
import com.mirror.alogeda.commons.repository.CidadeRepository;

@Service
public class CidadeService extends CrudService<Cidade> {
	private CidadeRepository cidadeRepository;

	@Autowired
	public CidadeService(CidadeRepository cidadeRepository) {
		this.cidadeRepository = cidadeRepository;
		setGenericRepository(cidadeRepository);
	}

	}
