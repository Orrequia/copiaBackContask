package com.fot.backcontask.exception;

public class NotFoundException extends Exception {

	private static final long serialVersionUID = 1689769876L;

	private static final String MSG = "Esta entidad no existe";
	
	public NotFoundException(String message) {
		super(message);
	}
	
	public NotFoundException() {
		super(MSG);
}
}
