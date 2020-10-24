package com.pradhumna.springboot.curd.curddemo.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pradhumna.springboot.curd.curddemo.entity.Employee;
import com.pradhumna.springboot.curd.curddemo.service.EmployeeService;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

	private EmployeeService employeeService;

	@Autowired
	public EmployeeRestController(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}
	
	@GetMapping("/employee")
	public List<Employee> findAll(){
		return employeeService.findAll();
	}
	
	
	@GetMapping("/employee/{empId}")
	public Employee getEmployee(@PathVariable int empId) {
		Employee emp = employeeService.findByEmployee(empId);
		 
		if(emp==null) {
			throw new RuntimeException("Employee id not found : " + empId);
			
		}
		
		return emp;
	}
	
	@PostMapping("/employee")
	public Employee addEmployee(@RequestBody Employee emp) {
		emp.setId(0);
		
		employeeService.save(emp);
		return emp;
	}
	
	
	@PutMapping("/employee")
	public Employee updateEmployee(@RequestBody Employee emp) {
		
		employeeService.save(emp);
		
		return emp;
	}
	
	
	
	@DeleteMapping("/employee/{empId}")
	public String deleteEmployee(@PathVariable int empId) {
		Employee emp = employeeService.findByEmployee(empId);
		if(emp==null) {
			throw new RuntimeException("Employee id not found"  + empId);
		}
		employeeService.delete(empId);
		
		return "Deleted employee id "  + empId;
	}
	
	
}
