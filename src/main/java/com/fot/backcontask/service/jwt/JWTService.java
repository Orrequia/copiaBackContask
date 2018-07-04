package com.fot.backcontask.service.jwt;

import com.fot.backcontask.dto.auth.LoginDTO;
import com.fot.backcontask.dto.auth.TokenDTO;
import com.fot.backcontask.dto.auth.ValidTokenDTO;
import com.fot.backcontask.exception.InvalidUserException;
import com.fot.backcontask.model.User;

public interface JWTService {
	
	TokenDTO loginUser(LoginDTO login) throws InvalidUserException;

	ValidTokenDTO validateToken(String token);
}
