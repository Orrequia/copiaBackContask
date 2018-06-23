package com.fot.backcontask.service.servletrequest;

import javax.servlet.http.HttpServletRequest;

import com.fot.backcontask.exception.InvalidRequestException;

public interface ServletRequestService {

	String extractToken(HttpServletRequest request) throws InvalidRequestException;
}
