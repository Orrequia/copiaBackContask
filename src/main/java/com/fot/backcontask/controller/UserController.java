package com.fot.backcontask.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fot.backcontask.component.mapper.user.UserMapper;
import com.fot.backcontask.dto.user.UserDTO;
import com.fot.backcontask.dto.user.UserPostDTO;
import com.fot.backcontask.exception.InvalidRequestException;
import com.fot.backcontask.exception.NotFoundException;
import com.fot.backcontask.model.User;
import com.fot.backcontask.service.user.UserService;

@RestController
@RequestMapping(value= "/user")
public class UserController {

	@Autowired
	UserService userService;
	
	@Autowired
	UserMapper userMapper;
	
	@GetMapping
	public List<UserDTO> findAll(@RequestParam(defaultValue = "0", required= false ) Integer page, 
							 @RequestParam(defaultValue = "10", required= false ) Integer size) throws InvalidRequestException {
		final List<User> users = userService.findAll(PageRequest.of(page, size));
		return userMapper.modelToDto(users);
	}
	
	@GetMapping("/{idUser}")
	public UserDTO findById(@PathVariable("idUser") Long id) throws NotFoundException {
		final User user = userService.getAndCheck(id);
		return userMapper.modelToDto(user);
	}
	
	@PostMapping
	public UserDTO create(@RequestBody UserPostDTO dto) throws InvalidRequestException, NotFoundException {
		if(dto.getIdUser() != null) 
			throw new InvalidRequestException("El idUser no se puede recibir en el body");
		final User user = userMapper.dtoToModel(dto);
		final User createUser = userService.create(user);
		return userMapper.modelToDto(createUser);
	}
	
	@PutMapping("/{idUser}")
	public void update(@PathVariable("idUser") Long id, @RequestBody UserPostDTO dto) throws InvalidRequestException, NotFoundException {
		if(dto.getIdUser() != null) 
			throw new InvalidRequestException("El idUser no se puede recibir en el body");
		final User user = userService.getAndCheck(id);
		userService.setValues(user, userMapper.dtoToModel(dto));
		userService.update(user);
	}
	
	@DeleteMapping("/{idUser}")
	public void delete(@PathVariable("idUser") Long id, @RequestBody UserDTO dto) throws InvalidRequestException, NotFoundException {
		final User user = userService.getAndCheck(id);
		if(!userService.isEqual(userMapper.dtoToModel(dto), user)) 
			throw new InvalidRequestException("El usuario recibido no coincide con el almacenado");
		userService.delete(user);
}
}
