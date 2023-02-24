package com.mu_dukani.prathamadokan.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	private String resourceName;
	private String fieldName;
	private Long objectValue;

	public ResourceNotFoundException(String resourceName, String fieldName, Long id) {
		super(String.format(fieldName, resourceName, id));
		this.resourceName = resourceName;
		this.fieldName = fieldName;
		this.objectValue = id;
	}

	public ResourceNotFoundException() {
		super();
	}

//	public ResourceNotFoundException(String resourceName) {
//		super(resourceName);
//	}
//	
//	public ResourceNotFoundException(String fieldName) {
//		super(fieldName);
//	}
	public String getResourceName() {
		return resourceName;
	}

	public String getFieldName() {
		return fieldName;
	}

	public Long getObjectValue() {
		return objectValue;
	}

}
