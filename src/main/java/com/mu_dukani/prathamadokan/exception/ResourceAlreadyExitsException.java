package com.mu_dukani.prathamadokan.exception;

public class ResourceAlreadyExitsException extends RuntimeException {

	private String message;

	public ResourceAlreadyExitsException() {
		super();
	}

	public ResourceAlreadyExitsException(String message) {
		super(message);
		this.message = message;
	}

}
