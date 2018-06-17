package com.mirror.alogeda.commons.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import com.mirror.alogeda.commons.model.Cbo;
import com.mirror.alogeda.commons.model.Escolaridade;
import com.mirror.alogeda.commons.model.Setores;
import com.mirror.alogeda.commons.repository.CboRepository;
import com.mirror.alogeda.commons.repository.EscolaridadeRepository;

@Service
public class EscolaridadeService extends CrudService<Escolaridade> {

    @Autowired
    public EscolaridadeService(EscolaridadeRepository escolaridadeRepository) {
        super(escolaridadeRepository);
    }

}
