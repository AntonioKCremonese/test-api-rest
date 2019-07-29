package com.br.antonio.testapi.error;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ObjectError implements Serializable {
	
	
	private static final long serialVersionUID = 1L;
	
	private final String message;
    private final String field;
    private final Object parameter;
}
