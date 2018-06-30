package com.mirror.alogeda.commons.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.mirror.alogeda.commons.model.Vagas;
import com.mirror.alogeda.commons.repository.VagasRepository;

@Service
public class VagasService extends CrudService<Vagas> {

	@Autowired
	public VagasService(VagasRepository Repository) {
		super(Repository);
	}
}
