package com.fot.backConTask.service.servletrequest;

import javax.servlet.http.HttpServletRequest;

import com.fot.backConTask.exception.InvalidRequestException;

public interface ServletRequestService {

	String extractToken(HttpServletRequest request) throws InvalidRequestException;
}
