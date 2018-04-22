package com.mirror.alogeda.commons.service;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public abstract class CrudService<T> {
private JpaRepository<T, Integer> genericRepository;

protected void setGenericRepository(JpaRepository<T, Integer> genericRepository) {
	this.genericRepository = genericRepository;
}

@Transactional(propagation = Propagation.REQUIRED)
public void save(T entidade) {
	genericRepository.save(entidade);
}

@Transactional(propagation = Propagation.REQUIRED)
public void delete(T entidade) {
	genericRepository.delete(entidade);
}

public List<T> getAll() {
	return genericRepository.findAll();
}

}