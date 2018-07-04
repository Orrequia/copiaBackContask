package com.fot.backcontask.service.servletrequest;

import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;

import com.fot.backcontask.exception.InvalidRequestException;

@Service
public class ServletRequestServiceImpl implements ServletRequestService {

	private static final String HEADER_NAME = "Authorization";
	
	@Override
	public String extractToken(HttpServletRequest request) throws InvalidRequestException {
		String token =  Optional.ofNullable(request.getHeader(HEADER_NAME))
			.orElseThrow(() -> new InvalidRequestException("No se ha incluido en el header el token, por favor introduzca el nombre 'Authorization' con su token"));
		if(!token.startsWith("Bearer "))
			throw new InvalidRequestException("El token inicio del token es inválido, por favor revise el token");
		return token.substring(7);
	}
}
