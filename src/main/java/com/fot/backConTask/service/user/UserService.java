package com.fot.backConTask.service.user;

import com.fot.backConTask.dto.LoginDTO;
import com.fot.backConTask.exception.InvalidUserException;
import com.fot.backConTask.model.User;
import com.fot.backConTask.service.Service;

public interface UserService extends Service<User, Integer> {
	
	public User findUser(LoginDTO login) throws InvalidUserException;
}
