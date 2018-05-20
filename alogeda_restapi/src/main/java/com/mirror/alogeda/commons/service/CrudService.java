package com.mirror.alogeda.commons.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public abstract class CrudService<T> {
	private JpaRepository<T, Integer> genericRepository;

	public CrudService(JpaRepository<T, Integer> genericRepository) {
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

	public Optional<T> buscaPorId(int entidadeId) {
		return genericRepository.findById(entidadeId);
	}

}
