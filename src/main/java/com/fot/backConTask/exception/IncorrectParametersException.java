package com.fot.backConTask.exception;

public class IncorrectParametersException extends Exception {

	private static final long serialVersionUID = 907897981L;

	public static final String MSG = "Los valores de los parámetros son incorrectos";
	
	public IncorrectParametersException() {
		super(MSG);
	}
	
	public IncorrectParametersException(String message) {
		super(message);
	}
}
