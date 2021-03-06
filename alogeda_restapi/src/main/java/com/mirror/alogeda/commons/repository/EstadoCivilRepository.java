package com.mirror.alogeda.commons.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mirror.alogeda.commons.model.EstCivil;

@Repository
public interface EstadoCivilRepository extends JpaRepository<EstCivil, Integer> {
}
