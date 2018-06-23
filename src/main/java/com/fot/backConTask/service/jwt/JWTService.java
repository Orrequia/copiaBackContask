package com.fot.backConTask.service.jwt;

import com.fot.backConTask.dto.LoginDTO;
import com.fot.backConTask.dto.TokenDTO;
import com.fot.backConTask.dto.ValidTokenDTO;
import com.fot.backConTask.exception.InvalidUserException;

public interface JWTService {
	
	TokenDTO loginUser(LoginDTO login) throws InvalidUserException;
	
	ValidTokenDTO validateToken(String token);
}
