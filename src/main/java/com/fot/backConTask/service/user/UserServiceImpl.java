package com.fot.backConTask.service.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fot.backConTask.dao.UserDAO;
import com.fot.backConTask.dto.LoginDTO;
import com.fot.backConTask.exception.InvalidUserException;
import com.fot.backConTask.model.User;
import com.fot.backConTask.service.AbstractService;

@Service
public class UserServiceImpl extends AbstractService<User, UserDAO> implements UserService{

	@Autowired
	UserDAO userDAO;
	
	@Override
	public User findUser(LoginDTO login) throws InvalidUserException {
		return userDAO.findOneByUsernameAndPassword(login.getUsername(), login.getPassword())
				.orElseThrow(() -> new InvalidUserException());
	}
}
