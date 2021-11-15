package com.rest.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.rest.model.Employee;
import com.rest.service.EmployeeService;
import com.sun.tools.sjavac.Log;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
	
	Logger logger = LoggerFactory.getLogger(EmployeeController.class);
	@Autowired
	private EmployeeService employeeservice;
	

@ApiOperation(value="GetAll ",notes=" get All Employees")
	@GetMapping("/view")
	public ResponseEntity<List<Employee>> viewEmployee()
	{
	 return ResponseEntity.ok().body(employeeservice.getAllEmployee());
	}
	@PostMapping("/add")
	public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee)
	{
try {
	
	return ResponseEntity.ok().body(this.employeeservice.addEmployee(employee));
} 
catch (Exception e) {
   	   logger.warn("error in adding user"+employee.toString());
}
	return null;	
	}
	@GetMapping("/{id}")
	public ResponseEntity<Employee> findEmployeeByID(@PathVariable int id)
	{    logger.trace("Trace Message!");
	logger.debug("Debug Message!");
	logger.info("Info Message!");
	logger.warn("Warn Message!");
	logger.error("Error Message!");
	//logger.fatal("Fatal Message!");
logger.trace("string");
		return ResponseEntity.ok().body(employeeservice.findEmployeeByID(id));	

	}
	@PutMapping("/{id}")
	public ResponseEntity<Employee>updateEmployee(@PathVariable int id,@RequestBody Employee employee)
	{ 
		employee.setId(id);
		return ResponseEntity.ok().body( this.employeeservice.updateEmployee(employee));
	}
	@DeleteMapping("/{id}")
	public void deleteEmployee(@PathVariable(value="id") int id)
	{
		this.employeeservice.DeleteById(id);
	}
	@GetMapping("/search")
	 public ResponseEntity<List<Employee>> viewSearchPage(@Param(value = "name") String name)
	 {
		System.out.println(employeeservice.findByuserName(name));
		return ResponseEntity.ok().body(employeeservice.findByuserName(name));	 
	 }
	
}
