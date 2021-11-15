package com.rest.exceptions;

public class EmployeeAlreadyPresentException extends RuntimeException {
	public EmployeeAlreadyPresentException() {
		super("Employee is already present for this ");
		// TODO Auto-generated constructor stub
	}

	public EmployeeAlreadyPresentException(String message) {
		super("Employee is already present for this "+message);
		// TODO Auto-generated constructor stub
	}
}
