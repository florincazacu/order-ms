package com.example.order.service;

import java.util.Set;

public interface CrudService<T, ID> {
	
	Set<T> findAll();
	
	T findById(ID id);
	
	T save(T entity);
	
	void delete(T entity);
	
	void deleteById(ID id);

	void update(ID id, T entity);
}
