package com.mirror.alogeda.commons.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.mirror.alogeda.commons.model.Atestados;
import com.mirror.alogeda.commons.model.Funcionarios;

@Repository
public interface FuncionariosRepository extends JpaRepository<Funcionarios, Integer> {
	
	@Query ("select f from Funcionarios f left join fetch f.pessoas where f.pessoas.nome like '%' ||  ?1 || '%' ")
List<Funcionarios> findByName2(String nome);
	

	@Query ("select f from Funcionarios f left join fetch f.pessoas where f.id=?1 ")
List<Funcionarios> buscaId (int id);
}

