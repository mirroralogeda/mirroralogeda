package com.mirror.alogeda.commons.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import com.mirror.alogeda.commons.model.AreasAtuacao;

import com.mirror.alogeda.commons.repository.AreasAtuacaoRepository;


@Service
public class AreasAtuacaoService extends CrudService<AreasAtuacao> {

    @Autowired
    public AreasAtuacaoService(AreasAtuacaoRepository AreasAtuacaoRepository) {
        super(AreasAtuacaoRepository);
    }



}
