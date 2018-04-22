package com.mirror.alogeda.commons.helper.crudhelper;

import java.util.List;

public interface Crud<T> {
void save(T entity);
List<T> getAll();
void delete(T entity);
}
