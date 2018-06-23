package com.fot.backcontask.service.jwt;

import com.fot.backcontask.dto.LoginDTO;
import com.fot.backcontask.dto.TokenDTO;
import com.fot.backcontask.dto.ValidTokenDTO;
import com.fot.backcontask.exception.InvalidUserException;

public interface JWTService {
	
	TokenDTO loginUser(LoginDTO login) throws InvalidUserException;
	
	ValidTokenDTO validateToken(String token);
}
