package com.university_app.exception;

public class CandidateNotFoundException extends RuntimeException{

	public CandidateNotFoundException(String msg) {
		super (msg);
	}
}
