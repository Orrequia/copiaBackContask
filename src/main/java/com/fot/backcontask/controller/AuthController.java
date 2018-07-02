package com.fot.backcontask.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fot.backcontask.dto.ApiErrorDTO;
import com.fot.backcontask.dto.auth.LoginDTO;
import com.fot.backcontask.dto.auth.TokenDTO;
import com.fot.backcontask.dto.auth.ValidTokenDTO;
import com.fot.backcontask.exception.InvalidRequestException;
import com.fot.backcontask.exception.InvalidUserException;
import com.fot.backcontask.service.jwt.JWTService;
import com.fot.backcontask.service.servletrequest.ServletRequestService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping(value="/auth")
public class AuthController {
	
	@Autowired
	private JWTService jwtService;

	@Autowired
	private ServletRequestService requestService;

	@ApiOperation(notes = "Genera un token en caso de ser válidos los datos de registro", tags = { "Login" }, value = "Login user")
	@ApiResponses({ @ApiResponse(code = 200, response = TokenDTO.class, message = "Login!"),
			@ApiResponse(code = 401, response = ApiErrorDTO.class, message = "Bad credentials") })
	@PostMapping("/login")
	public ResponseEntity<TokenDTO> token(@RequestBody LoginDTO login) throws InvalidUserException {
		final TokenDTO res = jwtService.loginUser(login);
		return ResponseEntity.ok(res);
	}

	@ApiOperation(notes = "Comprueba la validez de un token", tags = { "Login" }, value = "Validate token")
	@ApiResponses({ @ApiResponse(code = 200, response = ValidTokenDTO.class, message = ""),
			@ApiResponse(code = 401, response = ApiErrorDTO.class, message = "Bad credentials") })
	public ResponseEntity<ValidTokenDTO> validate(HttpServletRequest request) throws InvalidRequestException {
		final String header = requestService.extractToken(request);
		return ResponseEntity.ok(jwtService.validateToken(header));
	}
}
