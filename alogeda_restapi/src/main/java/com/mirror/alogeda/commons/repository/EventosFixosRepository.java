package com.mirror.alogeda.commons.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

import com.mirror.alogeda.commons.model.EveFixos;

@Repository
public interface EventosFixosRepository extends JpaRepository<EveFixos, Integer> {
    @Query("SELECT ef FROM EveFixos ef INNER JOIN fetch ef.funcionarios fun INNER JOIN fetch ef.eventos eve WHERE fun.id = ?1 and eve.id = ?2 and ?3 between ef.perInicial and ef.perFinal")
    List<EveFixos> buscaEveFixos(int idFuncionario, int idEvento, Date data);
}
