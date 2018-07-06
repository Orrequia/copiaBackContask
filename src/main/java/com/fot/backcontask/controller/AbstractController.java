package com.fot.backcontask.controller;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.fot.backcontask.component.mapper.Mapper;
import com.fot.backcontask.exception.InvalidRequestException;
import com.fot.backcontask.exception.NotFoundException;
import com.fot.backcontask.service.Service;

public abstract class AbstractController<T, E, M> implements Controller<E> {

	@Autowired
	Service<T, Long> service;
	
	@Autowired
	Mapper<T, E> mapper;
	
	@GetMapping
	public List<E> findAll(@RequestParam(defaultValue = "0", required= false ) Integer page, 
							 @RequestParam(defaultValue = "10", required= false ) Integer size) throws InvalidRequestException {
		final List<T> models = service.findAll(PageRequest.of(page, size));
		return mapper.modelToDto(models);
	}
	
	@GetMapping("/{idUser}")
	public E findById(@PathVariable("idUser") Long id) throws NotFoundException {
		final T model = service.getAndCheck(id);
		return mapper.modelToDto(model);
	}
	
	@PostMapping
	public E create(HttpServletRequest request, @RequestBody E dto) throws InvalidRequestException, NotFoundException, NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		Method method = clazz().getMethod("getId" + clazz());
		if(method.invoke(dto) != null)
			throw new InvalidRequestException("El idUser no se puede recibir en el body");
		final T user = mapper.dtoToModel(dto);
		final T createUser = service.create(user);
		return mapper.modelToDto(createUser);
	}
	
	@PutMapping("/{idUser}")
	public void update(@PathVariable("idUser") Long id, @RequestBody E dto) throws InvalidRequestException, NotFoundException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
		Method method = clazz().getMethod("getId" + clazz());
		if(method.invoke(dto) != null) 
			throw new InvalidRequestException("El idUser no se puede recibir en el body");
		final T model = service.getAndCheck(id);
		service.setValues(model, mapper.dtoToModel(dto));
		service.update(model);
	}
	
	@DeleteMapping("/{idUser}")
	public void delete(@PathVariable("idUser") Long id, @RequestBody E dto) throws InvalidRequestException, NotFoundException {
		final T model = service.getAndCheck(id);
		if(!service.isEqual(mapper.dtoToModel(dto), model)) 
			throw new InvalidRequestException("El usuario recibido no coincide con el almacenado");
		service.delete(model);
	}
}