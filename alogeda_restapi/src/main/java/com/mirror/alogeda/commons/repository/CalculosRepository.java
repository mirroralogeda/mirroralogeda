package com.mirror.alogeda.commons.repository;

import java.util.Date;
import java.util.List;

import com.mirror.alogeda.commons.model.Calculos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CalculosRepository extends JpaRepository<Calculos, Integer> {
    //@Query("select new com.mirror.alogeda.commons.model.viewmodel.PeriodoCalculo(p.perInicial, p.perFinal, (select count(distinct c.dataCalculo) from Calculos c where c.perIncial = p.perInicial and c.perFinal = p.perFinal), (select function('bool_or', c.per_fechado) from Calculos c where c.perIncial = p.perInicial and c.perFinal = p.perFinal)) from ParametrosFolha p")
//public List<PeriodoCalculo> getPeriodos();
public List<Calculos> findByDataCalculoBetween(Date dataInicio, Date dataFinal);
public List<Calculos> findByDataCalculo(Date data);
}
