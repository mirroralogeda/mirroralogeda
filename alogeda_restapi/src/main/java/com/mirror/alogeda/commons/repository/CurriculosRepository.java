package com.mirror.alogeda.commons.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

import com.mirror.alogeda.commons.model.Cargos;
import com.mirror.alogeda.commons.model.Curriculos;

@Repository
public interface CurriculosRepository extends JpaRepository<Curriculos, Integer> {
    
	
	 @Query("select c from Curriculos as c join fetch c.pessoas")
	    public List<Curriculos> findAllCompleto();
}
