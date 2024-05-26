package com.validate.validations_Exceptionss.advice;

import org.springframework.http.HttpStatus;

public class ExceptionMessage {
	private HttpStatus statuscode;
	private String exception;
	private String message;
	public ExceptionMessage(HttpStatus statuscode, String exception, String message) {
		super();
		this.statuscode = statuscode;
		this.exception = exception;
		this.message = message;
	}
	public HttpStatus getStatuscode() {
		return statuscode;
	}
	public void setStatuscode(HttpStatus statuscode) {
		this.statuscode = statuscode;
	}
	public String getException() {
		return exception;
	}
	public void setException(String exception) {
		this.exception = exception;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}

}
