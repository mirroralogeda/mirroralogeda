package com.mirror.alogeda.commons.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import com.mirror.alogeda.commons.model.Cargos;
import com.mirror.alogeda.commons.model.Curriculos;
import com.mirror.alogeda.commons.repository.CargosRepository;
import com.mirror.alogeda.commons.repository.CurriculosRepository;

@Service
public class CurriculosService extends CrudService<Curriculos> {

	@Autowired
	private CurriculosRepository repository;
	
    @Autowired
    public CurriculosService(CurriculosRepository curriculosRepository) {
        super(curriculosRepository);
    }
    
    public List<Curriculos> findAllCompleto() {
        return repository.findAllCompleto();
    }

}
