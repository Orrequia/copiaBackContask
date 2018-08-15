package com.fot.backcontask.service.user;

import java.util.Optional;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.fot.backcontask.dao.UserDAO;
import com.fot.backcontask.exception.NotFoundException;
import com.fot.backcontask.model.User;
import com.fot.backcontask.service.AbstractService;

@Service(value = "userService")
public class UserServiceImpl extends AbstractService<User, UserDAO> implements UserService {

	@Autowired
	UserDAO userDAO;
	
	@Override
	public User getAndCheck(Long idUser) throws NotFoundException {
		return findById(idUser).orElseThrow(() -> new NotFoundException("El usuario no existe"));
	}
	
	@Override
	public boolean isEqual(User u1, User u2) {
		return StringUtils.equals(u1.getName(), u2.getName()) &&
				StringUtils.equals(u1.getEmail(), u2.getEmail()) &&
				StringUtils.equals(u1.getPhone(), u2.getPhone()) &&
				StringUtils.equals(u1.getUsername(), u2.getUsername()) &&
				u1.getRole().equals(u2.getRole());
	}
	
	@Override
	public void setValues(User to, User from) {
		to.setName(from.getName());
		to.setEmail(from.getEmail());
		to.setPhone(from.getPhone());
		to.setUsername(from.getUsername());
		to.setPassword(from.getPassword());
		to.setRole(from.getRole());
	}
	
	@Override
	public Optional<User> findByUsername(String username) {
		return userDAO.findOneByUsername(username);
	}
}
