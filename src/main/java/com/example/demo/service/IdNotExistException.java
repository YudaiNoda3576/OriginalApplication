package com.example.demo.service;

public class IdNotExistException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public IdNotExistException(String message) {
		super(message);
	}

}
