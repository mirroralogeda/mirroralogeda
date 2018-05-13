package com.mirror.alogeda.commons.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mirror.alogeda.commons.model.Enderecos;

@Repository
public interface EnderecosRepository extends JpaRepository<Enderecos, Integer> {

}
