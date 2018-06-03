package com.mirror.alogeda.commons.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.mirror.alogeda.commons.model.EveFixos;
import com.mirror.alogeda.commons.repository.EventosFixosRepository;

@Service
public class EventosFixosService extends CrudService<EveFixos> {

	@Autowired
	public EventosFixosService(EventosFixosRepository Repository) {
		super(Repository);
	}
}
