package com.pradhumna.springboot.curd.curddemo.service;

import java.util.List;

import com.pradhumna.springboot.curd.curddemo.entity.Employee;

public interface EmployeeService {

	public List<Employee> findAll();	

	public Employee findByEmployee(int id);
	
	public void save(Employee emp);
	
	public void delete(int id);
}
