package com.rest.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.rest.exceptions.EmployeeAlreadyPresentException;
import com.rest.exceptions.EmployeeNotFoundException;
import com.rest.model.Employee;
import com.rest.repository.EmployeeRepository;
@Service
public class EmployeeServiceImp  implements EmployeeService{

	@Autowired
	private EmployeeRepository employeerepository;
	
	@Override
	public List<Employee> getAllEmployee() {
	//	Pageable paging = PageRequest.of(pageNo-1, pageSize);
	//	Page<Employee> pagedResult = employeerepository.findAll(paging);
	//	 List < Employee > listEmployees = pagedResult.getContent();
		 
		return employeerepository.findAll();
	}

	@Override
	public Employee addEmployee( Employee employee) {
	/*	Optional < Employee > emp = this.employeerepository.findById(employee.getId());	
		if(employeerepository.existsById(employee.getId()))
		{
			throw new EmployeeAlreadyPresentException(" id : " + employee.getId());
		}
		return this.employeerepository.save(employee);  */
		
		List<Employee> findAll = employeerepository.findAll();
	  findAll.stream().map(s->{
	    	if(s.getId()!=employee.getId())
	    	{
	    		return  employeerepository.save(employee);
	    	}
	    	else
	    	{
	    		throw new EmployeeAlreadyPresentException(" id : " + employee.getId());	
	    	}
	     });
	
	return null;
	}

	@Override
	public Employee findEmployeeByID(int id) {
		Optional < Employee > emp = this.employeerepository.findById(id);
		if (emp.isPresent()) 
		{
		return emp.get();
		}
		else {
		    throw new EmployeeNotFoundException("with  id : " + id);
		}
	}

	@Override
	public Employee updateEmployee(Employee employee) {
Optional < Employee > emp = this.employeerepository.findById(employee.getId());
if (emp.isPresent()) 
{
Employee empUpdate=emp.get();
empUpdate.setId(employee.getId());
empUpdate.setName(employee.getName());
empUpdate.setSalary(employee.getSalary());
employeerepository.save(employee);
	return empUpdate;
	}
else {
    throw new EmployeeNotFoundException("with id : " + employee.getId());
}
	}
	@Override
	public void DeleteById(int id) {
		Optional < Employee > emp = this.employeerepository.findById(id);	
		if (emp.isPresent()) 
		{
    this.employeerepository.deleteById(id);
	}
		else
		{
throw new EmployeeNotFoundException("with  id : " + id);
			}	
		}

	@Override
	public List<Employee> findByuserName(String name) {
		 if (name != null) {
			 System.out.println(name);
		
	           return employeerepository.findByuserName(name);
	        }
	        return employeerepository.findAll();
	}
		
}
