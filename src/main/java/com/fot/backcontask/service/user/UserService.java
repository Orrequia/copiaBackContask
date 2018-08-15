package com.fot.backcontask.service.user;

import java.util.Optional;

import com.fot.backcontask.model.User;
import com.fot.backcontask.service.Service;

public interface UserService extends Service<User, Long> {
	
	Optional<User> findByUsername(String username);
}
