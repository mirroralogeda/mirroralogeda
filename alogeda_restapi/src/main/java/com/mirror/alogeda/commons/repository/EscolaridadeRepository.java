package com.mirror.alogeda.commons.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

import com.mirror.alogeda.commons.model.Cbo;
import com.mirror.alogeda.commons.model.Escolaridade;

@Repository
public interface EscolaridadeRepository extends JpaRepository<Escolaridade, Integer> {
}
