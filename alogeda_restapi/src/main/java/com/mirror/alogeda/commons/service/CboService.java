package com.mirror.alogeda.commons.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import com.mirror.alogeda.commons.model.Cbo;
import com.mirror.alogeda.commons.model.Setores;
import com.mirror.alogeda.commons.repository.CboRepository;

@Service
public class CboService extends CrudService<Cbo> {

    @Autowired
    public CboService(CboRepository cboRepository) {
        super(cboRepository);
    }

}
