package com.mirror.alogeda.commons.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import com.mirror.alogeda.commons.model.Atestados;
import com.mirror.alogeda.commons.model.Cargos;
import com.mirror.alogeda.commons.model.Dependentes;
import com.mirror.alogeda.commons.repository.AtestadosRepository;
import com.mirror.alogeda.commons.repository.CargosRepository;
import com.mirror.alogeda.commons.repository.DependentesRepository;

@Service
public class DependentesService extends CrudService<Dependentes> {

	DependentesRepository dependentesRepository;
    @Autowired
    public DependentesService(DependentesRepository DependentesRepository) {
        super(DependentesRepository);
        this.dependentesRepository = DependentesRepository;
    }
    public List<Dependentes> findByFuncionario(int funcionario){
    	
    	return dependentesRepository.findByFuncionario(funcionario);
    }
}
