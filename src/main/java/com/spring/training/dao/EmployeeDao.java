package com.spring.training.dao;

import com.spring.training.vo.Employeevo;

public interface EmployeeDao {
	void create(Employeevo employee);

	void deleteEmployee(Long id);

	Employeevo displayEmployee(Long id);

	void updateEmployee(Long id, Employeevo obj);

	void transactionTest(Long id, Employeevo employee);
}
