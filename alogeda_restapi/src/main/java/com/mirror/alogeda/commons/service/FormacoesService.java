package com.mirror.alogeda.commons.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import com.mirror.alogeda.commons.model.Formacoes;
import com.mirror.alogeda.commons.model.Setores;
import com.mirror.alogeda.commons.repository.CurriculosRepository;
import com.mirror.alogeda.commons.repository.FormacoesRepository;
import com.mirror.alogeda.commons.repository.SetoresRepository;

@Service
public class FormacoesService extends CrudService<Formacoes> {

	
	@Autowired
	private FormacoesRepository repository;
	
    @Autowired
    public FormacoesService(FormacoesRepository repository) {
        super(repository);
    }

    
    public List<?> findByCurriculo(int id) {
        return repository.findByCurriculo(id);
    }
}
