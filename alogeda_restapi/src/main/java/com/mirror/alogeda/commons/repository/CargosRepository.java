package com.mirror.alogeda.commons.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

import com.mirror.alogeda.commons.model.Cargos;

@Repository
public interface CargosRepository extends JpaRepository<Cargos, Integer> {
    // public List<Cargos> buscarCargosAbertos();

    @Query("select c from Cargos as c join fetch c.cbo join fetch c.setores")
    public List<Cargos> findAllCompleto();
}
