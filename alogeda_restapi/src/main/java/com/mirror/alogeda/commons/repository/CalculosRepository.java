package com.mirror.alogeda.commons.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mirror.alogeda.commons.model.Calculos;

@Repository
public interface CalculosRepository extends JpaRepository<Calculos, Integer> {

}
