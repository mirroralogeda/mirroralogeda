package com.mirror.alogeda.commons.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import com.mirror.alogeda.commons.model.Setores;
import com.mirror.alogeda.commons.repository.SetoresRepository;

@Service
public class SetoresService extends CrudService<Setores> {

    @Autowired
    public SetoresService(SetoresRepository setoresRepository) {
        super(setoresRepository);
    }

}
