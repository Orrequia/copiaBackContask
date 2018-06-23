package com.fot.backcontask.service.servletrequest;

import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import com.fot.backcontask.exception.InvalidRequestException;

public class ServletRequestServiceImpl implements ServletRequestService {

	private static final String HEADER_NAME = "Authorization";
	
	@Override
	public String extractToken(HttpServletRequest request) throws InvalidRequestException {
		return Optional.ofNullable(request.getHeader(HEADER_NAME))
				.orElseThrow(() -> new InvalidRequestException("No se ha incluido en el header el token, por favor introduzca el nombre 'Authorization' con su token"));
	}

}
