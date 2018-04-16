package com.pedrovcn.mydocumentsapi.exceptions;

public class MandatoryFieldMissingException extends RuntimeException {

	private static final long serialVersionUID = -5435410814111380095L;
	
	public MandatoryFieldMissingException(String message) {
		super(message);
	}

}
