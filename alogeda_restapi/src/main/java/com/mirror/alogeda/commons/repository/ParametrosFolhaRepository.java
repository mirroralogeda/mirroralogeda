package com.mirror.alogeda.commons.repository;

import java.util.Date;
import java.util.List;

import com.mirror.alogeda.commons.model.ParametrosFolha;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;;

@Repository
public interface ParametrosFolhaRepository extends JpaRepository<ParametrosFolha, Integer> {
    @Query("SELECT p FROM ParametrosFolha p WHERE ?1 between p.perInicial and p.perFinal")
    List<ParametrosFolha> findByVigencia(Date data);
}
