package com.br.antonio.testapi.error;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ErrorResponse {
	
	private String message;
	private Integer status;
	private List<ObjectError> errors;

}
