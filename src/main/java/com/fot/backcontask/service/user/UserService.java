package com.fot.backcontask.service.user;

import com.fot.backcontask.dto.LoginDTO;
import com.fot.backcontask.exception.InvalidUserException;
import com.fot.backcontask.model.User;
import com.fot.backcontask.service.Service;

public interface UserService extends Service<User, Integer> {
	
	public User findUser(LoginDTO login) throws InvalidUserException;
}
