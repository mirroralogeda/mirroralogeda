package com.mirror.alogeda.commons.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.mirror.alogeda.commons.model.TabSalFamilia;


@Repository
public interface TabSalFamiliaRepository extends JpaRepository<TabSalFamilia, Integer> {
	@Query("SELECT t FROM TabSalFamilia t WHERE ?1 between t.perInicial and t.perFinal order by t.perInicial")
	List<TabSalFamilia> findByVigencia(Date data);
}
