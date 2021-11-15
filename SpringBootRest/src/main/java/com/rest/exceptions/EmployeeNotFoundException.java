package com.rest.exceptions;

public class EmployeeNotFoundException extends RuntimeException{
	public EmployeeNotFoundException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public EmployeeNotFoundException(String message) {
		super("Employee Not .....Found"+message);
		// TODO Auto-generated constructor stub
	}
}
