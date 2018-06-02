package com.mirror.alogeda.commons.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.mirror.alogeda.commons.model.Atestados;
import com.mirror.alogeda.commons.model.Dependentes;

@Repository
public interface DependentesRepository extends JpaRepository<Dependentes, Integer> {
	@Query ("select d from Dependentes d where d.funcionarios.id = ?1")
	List<Dependentes> findByFuncionario(int funcionario);
}
