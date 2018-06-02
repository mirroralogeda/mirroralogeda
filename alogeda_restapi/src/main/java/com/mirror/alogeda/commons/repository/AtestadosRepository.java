package com.mirror.alogeda.commons.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.mirror.alogeda.commons.model.Atestados;

@Repository
public interface AtestadosRepository extends JpaRepository<Atestados, Integer> {
	@Query ("select v from Atestados v where v.funcionarios.id = ?1")
	List<Atestados> findByFuncionario(int funcionario);
}
