package com.mirror.alogeda.commons.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mirror.alogeda.commons.model.TabInss;


@Repository
public interface TabInssRepository extends JpaRepository<TabInss, Integer> {
	List<TabInss> findByPerFinalIsNull();
}
