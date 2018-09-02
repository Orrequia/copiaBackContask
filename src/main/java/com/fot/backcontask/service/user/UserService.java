package com.fot.backcontask.service.user;

import com.fot.backcontask.exception.NotFoundException;
import com.fot.backcontask.model.User;
import com.fot.backcontask.service.Service;

public interface UserService extends Service<User, Long> {
	
	User getAndCheckByUsername(String username) throws NotFoundException;
}
