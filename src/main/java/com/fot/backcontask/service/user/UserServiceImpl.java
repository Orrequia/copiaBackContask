package com.fot.backcontask.service.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fot.backcontask.dao.UserDAO;
import com.fot.backcontask.dto.auth.LoginDTO;
import com.fot.backcontask.exception.InvalidUserException;
import com.fot.backcontask.model.User;
import com.fot.backcontask.service.AbstractService;

@Service
public class UserServiceImpl extends AbstractService<User, UserDAO> implements UserService{

	@Autowired
	UserDAO userDAO;
	
	@Override
	public User findUser(LoginDTO login) throws InvalidUserException {
		return userDAO.findOneByUsernameAndPassword(login.getUsername(), login.getPassword())
				.orElseThrow(InvalidUserException::new);
	}
}
