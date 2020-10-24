package com.pradhumna.springboot.curd.curddemo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pradhumna.springboot.curd.curddemo.dao.EmployeeDAO;
import com.pradhumna.springboot.curd.curddemo.entity.Employee;


@Service
public class EmployeeServiceImpl implements EmployeeService {

	private EmployeeDAO employeeDAO;
	
	@Autowired
	public EmployeeServiceImpl(@Qualifier("employeeDAOJpaImpl") EmployeeDAO employeeDAO) {
		this.employeeDAO = employeeDAO;
	}

	@Override
	@Transactional
	public List<Employee> findAll() {
	
		return employeeDAO.findAll();
	}

	@Override
	@Transactional
	public Employee findByEmployee(int id) {
		// TODO Auto-generated method stub
		return employeeDAO.findByEmployee(id);
	}

	@Override
	@Transactional
	public void save(Employee emp) {
		employeeDAO.save(emp);

	}

	@Override
	@Transactional
	public void delete(int id) {
		employeeDAO.delete(id);

	}

}
