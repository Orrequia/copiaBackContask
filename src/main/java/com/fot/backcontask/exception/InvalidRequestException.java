package com.fot.backcontask.exception;

public class InvalidRequestException extends Exception {

	private static final long serialVersionUID = 907897981L;

	private static final String MSG = "Los petición enviada contiene valores incorrectos";
	
	public InvalidRequestException() {
		super(MSG);
	}
	
	public InvalidRequestException(String message) {
		super(message);
	}
}
