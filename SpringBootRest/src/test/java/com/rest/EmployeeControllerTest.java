package com.rest;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;

import com.rest.controller.EmployeeController;
import com.rest.model.Employee;
import com.rest.service.EmployeeService;

import lombok.RequiredArgsConstructor;

@ExtendWith(MockitoExtension.class)
@RequiredArgsConstructor
public class EmployeeControllerTest {

	@Autowired
	private MockMvc mockMvc;

	
	@Mock
	private EmployeeService employeeService;
	@InjectMocks
	private EmployeeController employeeController;
	
	List<Employee> 	empList = new ArrayList<Employee>();
    @Before
	public void setUp()
	{
    	this.mockMvc = MockMvcBuilders.standaloneSetup(employeeController).build();
empList.add(new Employee(1,"ankit",5000));
empList.add(new Employee(2,"amit",7000));
empList.add(new Employee(3,"arpit",8000));
	}
    @Test
	public void getAll() throws Exception
	{
    	Employee emp1 =new Employee(1,  "patel1", 2000);
    	when(employeeService.findEmployeeByID(1)).thenReturn(emp1);
    	this.mockMvc.perform(
				get("/employee/{id}")
				).andExpect(status().isOk())
				.andExpect(jsonPath("$.size()", is(empList.size())));
	}
	
}
