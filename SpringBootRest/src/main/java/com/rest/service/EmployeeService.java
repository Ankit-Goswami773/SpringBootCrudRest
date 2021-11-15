package com.rest.service;

import java.util.List;

import com.rest.model.Employee;

public interface EmployeeService {
	List<Employee> getAllEmployee();//int pageNo, int pageSize);
	Employee addEmployee(Employee employee);
	Employee findEmployeeByID(int id);
	Employee updateEmployee(Employee employee);
	void DeleteById(int id);
	 List<Employee> findByuserName(String keyword);
}
