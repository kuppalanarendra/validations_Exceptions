package com.validate.validations_Exceptionss.advice;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.validate.validations_Exceptionss.exceptions.UserAlreadyExists;
import com.validate.validations_Exceptionss.exceptions.UserNotFoundException;

@RestControllerAdvice
public class ResponseAdvice {
	@ResponseStatus
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public Map<String,String> userValidations(MethodArgumentNotValidException e){
		Map<String,String> map= new HashMap<>();
	List<FieldError> errors=	e.getBindingResult().getFieldErrors();
	for(FieldError error:errors) {
		map.put(error.getField(), error.getDefaultMessage());
	}
		return map;
		
	}
	
	@ResponseStatus(HttpStatus.NOT_FOUND)
	@ExceptionHandler(UserNotFoundException.class)
	public ResponseEntity userNotFound(UserNotFoundException e) {
		ExceptionMessage msg= new ExceptionMessage(HttpStatus.NOT_FOUND, "UserNotFoundException", e.getMessage());
		return new ResponseEntity<>(msg,HttpStatus.NOT_FOUND);
		
	}
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(UserAlreadyExists.class)
	public ResponseEntity alreadyExists(UserAlreadyExists e) {
		ExceptionMessage msg= new ExceptionMessage(HttpStatus.ALREADY_REPORTED, "UserAlreadyExists", e.getMessage());
		return new ResponseEntity<>(msg,HttpStatus.BAD_REQUEST);
		
	}
	

}
