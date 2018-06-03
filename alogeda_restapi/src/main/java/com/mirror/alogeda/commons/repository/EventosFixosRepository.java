package com.mirror.alogeda.commons.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.mirror.alogeda.commons.model.EveFixos;

@Repository
public interface EventosFixosRepository extends JpaRepository<EveFixos, Integer> {
}
