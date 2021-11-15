   package com.rest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import com.rest.model.Employee;
import com.rest.repository.EmployeeRepository;
import com.rest.service.EmployeeServiceImp;

import lombok.RequiredArgsConstructor;

@ExtendWith(MockitoExtension.class)
@RequiredArgsConstructor
public class EmployeeServiceImplTest {

	@Mock
	private EmployeeRepository employeerepository;

	@InjectMocks
	private EmployeeServiceImp employeeServiceImpl;
	List<Employee> empList = new ArrayList<Employee>();

	@BeforeEach
	public void setUp() {
		// MockitoAnnotations.openMocks(employeerepository);
		empList.add(new Employee(1, "ankit", 5000));
		empList.add(new Employee(2, "amit", 7000));
		empList.add(new Employee(3, "arpit", 8000));
	}

	@Test
	public void getAll() {
		when(employeerepository.findAll()).thenReturn(empList);
		List<Employee> list = employeeServiceImpl.getAllEmployee(); // System.out.print(list);
		assertEquals(3, list.size());
	}

	@Test
	void saveEmployee() throws Exception {
		Employee emp2 = new Employee(2, "Raj", 2000);

		when(employeerepository.save(emp2)).thenReturn(emp2);

		Employee result = employeeServiceImpl.addEmployee(emp2);

		assertEquals(2, result.getId());

	}

	@Test
	void testGetEmployeeById() throws Exception {
		Employee emp1 = new Employee(1, "patel1", 2000);
		when(employeerepository.findById(1)).thenReturn(Optional.of(emp1));

		Employee result = employeeServiceImpl.findEmployeeByID(1); //
		System.out.println(result);
		assertEquals(1, result.getId());

	}

	@Test
	void testGetEmployeeByname() throws Exception {

		when(employeerepository.findByuserName("ankit"))
				.thenReturn(empList.stream().filter(s -> s.getName() == "ankit").collect(Collectors.toList()));
		List<Employee> listofname = (List<Employee>) employeeServiceImpl.findByuserName("ankit");
		System.out.println("name" + listofname);
		assertEquals(1, listofname.size());
	}

	@Test
	void updatePrdouct() {
		Employee emp1 = new Employee(1, "abh", 20000);
		when(employeerepository.save(emp1)).thenReturn(emp1);
		emp1.setId(1);
		emp1.setName("amn");
		emp1.setSalary(12000);
		Employee employee = employeeServiceImpl.addEmployee(emp1);
		assertEquals(1, employee.getId());

	}
	/*
	 * @Test public void delete() { Employee emp1 =new Employee(1, "patel1", 2000);
	 * when(employeerepository.findById(1)).thenReturn(Optional.of(emp1));
	 * employeeServiceImpl.DeleteById(emp1.getId());
	 * verify(employeerepository.deleteById(emp1.getId()));
	 * 
	 * }
	 */
}
