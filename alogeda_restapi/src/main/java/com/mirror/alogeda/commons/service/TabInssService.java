package com.mirror.alogeda.commons.service;

import com.mirror.alogeda.commons.model.TabInss;
import com.mirror.alogeda.commons.repository.TabInssRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TabInssService extends CrudService<TabInss> {

	@Autowired
	public TabInssService(TabInssRepository tsfRepository) {
		super(tsfRepository);
	}

}
