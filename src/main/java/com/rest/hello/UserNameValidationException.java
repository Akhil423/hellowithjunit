package com.rest.hello;

public class UserNameValidationException extends RuntimeException {

	public UserNameValidationException(String userMessage) {
		
		super(userMessage);
	}

}
