package com.pedrovcn.mydocumentsapi.exceptions;

public class ExistingUserException extends RuntimeException {
	
	private static final long serialVersionUID = 5204955955540689755L;
	
	public ExistingUserException(String message) {
		super(message);
	}

}
