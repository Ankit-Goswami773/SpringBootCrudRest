package com.rest.exceptions;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class EmployeeAlreadyPresentAdvice {
	@ResponseBody
	  @ExceptionHandler(EmployeeAlreadyPresentException.class)
	String employeeNotFoundHandler(EmployeeAlreadyPresentException ex) {
	    return ex.getMessage();
}
}