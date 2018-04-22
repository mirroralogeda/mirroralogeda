package com.mirror.alogeda.commons.helper.crudhelper;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mirror.alogeda.commons.helper.EntidadeHelper;

public class CrudImpl<T> implements Crud<T>, CrudExceptD<T> {
	private JpaRepository<T, Integer> repository;

	public CrudImpl(JpaRepository<T, Integer> repository) {
		this.repository = repository;
	}

	@Override
	public void save(T entity) {
EntidadeHelper.assertExiste(entity);
repository.save(entity);
	}

	@Override
	public List<T> getAll() {
		return repository.findAll();
	}

	@Override
	public void delete(T entity) {
		EntidadeHelper.assertExiste(entity);
		repository.delete(entity);
	}

}
