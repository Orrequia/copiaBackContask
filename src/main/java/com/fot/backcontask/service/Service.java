package com.fot.backcontask.service;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Pageable;

import com.fot.backcontask.exception.InvalidRequestException;

public interface Service<T, I extends Serializable> {

	T create(T t);
	void update(T t);
	Optional<T> findById(I id);
	List<T> findAll(Pageable p) throws InvalidRequestException;
	void delete(T t);
}
