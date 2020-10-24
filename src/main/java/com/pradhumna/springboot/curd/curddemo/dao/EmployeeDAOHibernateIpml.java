package com.pradhumna.springboot.curd.curddemo.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.pradhumna.springboot.curd.curddemo.entity.Employee;

@Repository
public class EmployeeDAOHibernateIpml implements EmployeeDAO {

	
	private EntityManager entityManager;
	
	@Autowired
	public EmployeeDAOHibernateIpml(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	public List<Employee> findAll() {
	
		Session currentSession = entityManager.unwrap(Session.class);
		
		Query<Employee> query = currentSession.createQuery("from Employee",Employee.class);
		
		List<Employee> employee = query.getResultList();
		return employee;
	}

	@Override
	public Employee findByEmployee(int id) {
		Session currentSession = entityManager.unwrap(Session.class);
		
		Employee employee  = currentSession.get(Employee.class, id);
		return employee;
	}

	@Override
	public void save(Employee emp) {
		// TODO Auto-generated method stub
		Session currentSession = entityManager.unwrap(Session.class);
		currentSession.saveOrUpdate(emp);
		
		
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		Session currentSession = entityManager.unwrap(Session.class);
		Query theQuery = 
				currentSession.createQuery(
						"delete from Employee where id=:employeeId");
		theQuery.setParameter("employeeId", id);
		
		theQuery.executeUpdate();
	}
		
	}


