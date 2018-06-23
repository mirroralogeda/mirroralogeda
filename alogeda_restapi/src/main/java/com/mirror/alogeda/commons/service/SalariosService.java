package com.mirror.alogeda.commons.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import com.mirror.alogeda.commons.model.Atestados;
import com.mirror.alogeda.commons.model.Cargos;
import com.mirror.alogeda.commons.model.Salarios;
import com.mirror.alogeda.commons.repository.AtestadosRepository;
import com.mirror.alogeda.commons.repository.CargosRepository;
import com.mirror.alogeda.commons.repository.SalariosRepository;

@Service
public class SalariosService extends CrudService<Salarios> {

	SalariosRepository salariosRepository;
    @Autowired
    public SalariosService(SalariosRepository SalariosRepository) {
        super(SalariosRepository);
        this.salariosRepository = SalariosRepository;
    }
    public List<Salarios> findByFuncionario(int funcionario){
    	
    	return salariosRepository.findByFuncionario(funcionario);
    }
}
