package com.university_app.exception;

public class AdminNotFoundException extends RuntimeException{

	public AdminNotFoundException(String msg) {
		super(msg);
	}
}
