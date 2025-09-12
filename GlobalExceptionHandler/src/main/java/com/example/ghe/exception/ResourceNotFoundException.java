package com.example.ghe.exception;


public class ResourceNotFoundException extends RuntimeException {
	
	public ResourceNotFoundException(String message) {
	super(message);
	}
}