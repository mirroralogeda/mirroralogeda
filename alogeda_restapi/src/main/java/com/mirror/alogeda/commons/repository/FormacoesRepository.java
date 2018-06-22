package com.mirror.alogeda.commons.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

import com.mirror.alogeda.commons.model.Formacoes;
import com.mirror.alogeda.commons.model.Setores;

@Repository
public interface FormacoesRepository extends JpaRepository<Formacoes, Integer> {

	@Query("select f from Formacoes as f join fetch f.curriculos c where c.id = ?1")
    public List<?> findByCurriculo(int id);
}
