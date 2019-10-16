package com.spring.training.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.spring.training.dao.EmployeeDao;
import com.spring.training.vo.Employeevo;

@Component // create object
//@Service
@Qualifier("employeeServiceImpl")
public class EmployeeServiceImpl implements EmployeeService {
	@Autowired
	private EmployeeDao daoObject;

	public EmployeeServiceImpl() {
		System.out.println("########################################################: EmployeeServiceImpl");
	}

	@Override
	public void create(Employeevo employee) {
		System.out.println("service created 1");
		daoObject.create(employee);
	}

	@Override
	public void deleteEmployee(Long id) {

		daoObject.deleteEmployee(id);
	}

	@Override
	public Employeevo displayEmployee(Long id) {
		final Employeevo employeevo = daoObject.displayEmployee(id);
		return employeevo;
	}

	@Override
	public void updateEmployee(Long id, Employeevo obj) {
		daoObject.updateEmployee(id, obj);

	}

	@Override
	public void testTransaction(Long id, Employeevo employee) {
		daoObject.transactionTest(id, employee);
	}

}
