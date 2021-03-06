package com.mirror.alogeda.commons.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.mirror.alogeda.commons.model.Pessoas;


@Repository
public interface PessoasRepository extends JpaRepository<Pessoas, Integer> {
	
	
	Pessoas findByCpfContaining(String cpf);
}
