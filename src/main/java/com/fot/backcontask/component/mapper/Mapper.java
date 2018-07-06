package com.fot.backcontask.component.mapper;

import java.util.List;

import com.fot.backcontask.exception.NotFoundException;

public interface Mapper<T, E> {

	T dtoToModel(E dto) throws NotFoundException;
	E modelToDto(T model);
	List<T> dtoToModel(List<E> dtos) throws NotFoundException;
	List<E> modelToDto(List<T> models);
	Class<? extends E> dtoClazz();
	Class<? extends T> modelClazz();
}
