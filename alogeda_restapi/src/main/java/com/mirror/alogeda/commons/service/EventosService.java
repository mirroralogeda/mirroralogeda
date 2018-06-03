package com.mirror.alogeda.commons.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.mirror.alogeda.commons.model.Eventos;
import com.mirror.alogeda.commons.repository.EventosRepository;

@Service
public class EventosService extends CrudService<Eventos> {

	@Autowired
	public EventosService(EventosRepository Repository) {
		super(Repository);
	}
}
