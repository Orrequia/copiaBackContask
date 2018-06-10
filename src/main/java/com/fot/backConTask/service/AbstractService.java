package com.fot.backConTask.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;

import com.fot.backConTask.dao.GenericDAO;
import com.fot.backConTask.exception.IncorrectParametersException;

public class AbstractService<T, D extends GenericDAO<T>> implements Service<T, Integer> {

	private static final Integer MAXSIZE = new Integer(10);
	
	@Autowired
	D dao;
	
	@Override
	public T create(T t) {
		return dao.save(t);
	}

	@Override
	public void update(T t) {
		dao.save(t);
		
	}

	@Override
	public Optional<T> findById(Integer id) {
		return dao.findById(id);
	}

	@Override
	public List<T> findAll(Pageable p) throws IncorrectParametersException {
		if(p.getPageNumber() < 0 || p.getPageSize() <= 0 || p.getPageSize() > MAXSIZE)
			throw new IncorrectParametersException("Los parámetros introducidos contienen valores no permitidos, page mayor o igual a 0 y size entre 1 y " + MAXSIZE + " incluidos");
		return null;
	}

	@Override
	public void delete(T t) {
		dao.delete(t);
		
	}

}
