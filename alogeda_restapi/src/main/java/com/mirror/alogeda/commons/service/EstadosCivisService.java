package com.mirror.alogeda.commons.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.mirror.alogeda.commons.model.EstCivil;
import com.mirror.alogeda.commons.repository.EstadoCivilRepository;

@Service
public class EstadosCivisService extends CrudService<EstCivil> {

	@Autowired
	public EstadosCivisService(EstadoCivilRepository Repository) {
		super(Repository);
	}
}
