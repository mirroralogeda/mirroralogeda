package com.mirror.alogeda.commons.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mirror.alogeda.commons.model.TabIrrf;
import com.mirror.alogeda.commons.repository.TabIrrfRepository;

@Service
public class TabIrrfService extends CrudService<TabIrrf> {

	@Autowired
	public TabIrrfService(TabIrrfRepository tsfRepository) {
		super(tsfRepository);
	}

}
