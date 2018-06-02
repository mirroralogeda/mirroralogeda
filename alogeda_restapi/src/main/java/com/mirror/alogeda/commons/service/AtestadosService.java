package com.mirror.alogeda.commons.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import com.mirror.alogeda.commons.model.Atestados;
import com.mirror.alogeda.commons.model.Cargos;
import com.mirror.alogeda.commons.repository.AtestadosRepository;
import com.mirror.alogeda.commons.repository.CargosRepository;

@Service
public class AtestadosService extends CrudService<Atestados> {

	AtestadosRepository atestadosRepository;
    @Autowired
    public AtestadosService(AtestadosRepository AtestadosRepository) {
        super(AtestadosRepository);
        this.atestadosRepository = AtestadosRepository;
    }
    public List<Atestados> findByFuncionario(int funcionario){
    	
    	return atestadosRepository.findByFuncionario(funcionario);
    }
}
