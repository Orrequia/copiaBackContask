package com.fot.backcontask.service.user;

import com.fot.backcontask.dto.auth.LoginDTO;
import com.fot.backcontask.exception.InvalidUserException;
import com.fot.backcontask.exception.NotFoundException;
import com.fot.backcontask.model.User;
import com.fot.backcontask.service.Service;

public interface UserService extends Service<User, Long> {
	
	public User findUser(LoginDTO login) throws InvalidUserException;
	
	User getAndCheck(Long idUser) throws NotFoundException;
}
