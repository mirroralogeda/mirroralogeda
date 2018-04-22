package com.mirror.alogeda.commons.helper.crudhelper;

import java.util.List;

public interface CrudExceptD<T> {
	void save(T entity);
	List<T> getAll();
}
