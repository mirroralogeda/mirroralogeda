package com.mirror.alogeda.commons.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mirror.alogeda.commons.model.TabSalFamilia;
import com.mirror.alogeda.commons.repository.TabSalFamiliaRepository;

@Service
public class TabSalFamiliaService extends CrudService<TabSalFamilia> {

	@Autowired
	public TabSalFamiliaService(TabSalFamiliaRepository tsfRepository) {
		super(tsfRepository);
	}

	
}
