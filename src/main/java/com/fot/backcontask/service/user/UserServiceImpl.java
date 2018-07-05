package com.fot.backcontask.service.user;

import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.fot.backcontask.dao.UserDAO;
import com.fot.backcontask.exception.NotFoundException;
import com.fot.backcontask.model.User;
import com.fot.backcontask.service.AbstractService;

@Service
public class UserServiceImpl extends AbstractService<User, UserDAO> implements UserService, UserDetailsService {

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
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userDAO.findOneByUsername(username).orElseThrow(() -> new UsernameNotFoundException("El usuario o contraseña son incorrectos"));
		return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), getAuthority());
	}
	
	private List<SimpleGrantedAuthority> getAuthority() {
		return Arrays.asList(new SimpleGrantedAuthority("ROLE_ADMIN"));
	}
}
