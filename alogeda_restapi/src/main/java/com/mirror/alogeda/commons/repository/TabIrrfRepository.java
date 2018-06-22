package com.mirror.alogeda.commons.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.mirror.alogeda.commons.model.TabIrrf;


@Repository
public interface TabIrrfRepository extends JpaRepository<TabIrrf, Integer> {
	@Query("SELECT t FROM TabIrrf t WHERE ?1 between t.perInicial and t.perFinal order by t.perInicial")
	List<TabIrrf> findByVigencia(Date data);
}
