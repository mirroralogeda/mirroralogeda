package com.mirror.alogeda.commons.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.mirror.alogeda.commons.model.GrupoEventos;
import com.mirror.alogeda.commons.repository.GrupoEventosRepository;

@Service
public class GrupoEventosService extends CrudService<GrupoEventos> {

	@Autowired
	public GrupoEventosService(GrupoEventosRepository Repository) {
		super(Repository);
	}
}
