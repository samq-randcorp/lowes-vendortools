package com.lowes.vendortools.model;



import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ValidationError {
	
    public ValidationError(String message, ValidationErrorLevel error,Integer code) {
		this.message=message;
		this.validationErrorLevel=error;
		this.code=code;
	}
    private int code;
    private String message;
    private ValidationErrorLevel validationErrorLevel;
   
}
