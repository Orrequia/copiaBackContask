package com.fot.backcontask.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.fot.backcontask.dto.ApiErrorDTO;
import com.fot.backcontask.exception.InvalidRequestException;
import com.fot.backcontask.exception.InvalidUserException;

@ControllerAdvice(basePackages= { "com.fot.backcontask.controller" })
class ExceptionController {
	
	@ResponseStatus(HttpStatus.UNAUTHORIZED)
	@ExceptionHandler(InvalidRequestException.class)
	public ApiErrorDTO signatureException(InvalidRequestException e) {
		return new ApiErrorDTO(401, e.getMessage());
	}
	
	@ResponseStatus(HttpStatus.UNAUTHORIZED)
	@ExceptionHandler(InvalidUserException.class)
	public ApiErrorDTO invalidUserException(InvalidUserException e) {
		return new ApiErrorDTO(401, e.getMessage());
}
}
