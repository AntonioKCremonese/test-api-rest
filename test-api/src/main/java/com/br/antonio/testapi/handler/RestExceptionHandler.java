package com.br.antonio.testapi.handler;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.br.antonio.testapi.error.ErrorResponse;
import com.br.antonio.testapi.error.ObjectError;

@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {
	
	@Override
	protected ResponseEntity<Object> handleExceptionInternal(
			Exception ex, @Nullable Object body, HttpHeaders headers, HttpStatus status, WebRequest request) {
		
		ErrorResponse errorResponse = new ErrorResponse(ex.getMessage(),status.value(),null);
		
		return new ResponseEntity<>(errorResponse, headers, status);
	}
	
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, 
	                                                              HttpStatus status, WebRequest request) {
		List<ObjectError> errors = getErrors(ex);
		
		ErrorResponse errorResponse = new ErrorResponse(ex.getMessage(),
				status.value(),errors);
		
		return new ResponseEntity<>(errorResponse,headers,status);
	}

	private List<ObjectError> getErrors(MethodArgumentNotValidException ex) {
		
		return ex.getBindingResult().getFieldErrors().stream()
	            .map(error -> new ObjectError(error.getDefaultMessage(), error.getField(), error.getRejectedValue()))
	            .collect(Collectors.toList());
	}

}
