package com.mirror.alogeda.commons.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mirror.alogeda.commons.model.Salarios;

@Repository
public interface SalariosRepository extends JpaRepository<Salarios, Integer> {
	List<Salarios> findByVigFinalIsNull();
	List<Salarios> findByFuncionariosIdAndVigFinalIsNull(int id);
}
