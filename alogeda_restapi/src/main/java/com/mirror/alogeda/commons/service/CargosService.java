package com.mirror.alogeda.commons.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import com.mirror.alogeda.commons.model.Cargos;
import com.mirror.alogeda.commons.repository.CargosRepository;

@Service
public class CargosService extends CrudService<Cargos> {

    @Autowired
    public CargosService(CargosRepository cargosRepository) {
        super(cargosRepository);
    }

    @Autowired
    public List<Cargos> buscarCargosAbertos() {
        return getAll().stream().filter(x -> x.getVagases().size() > 0).collect(Collectors.toList());
    }

}
