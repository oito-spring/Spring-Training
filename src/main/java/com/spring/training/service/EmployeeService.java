package com.spring.training.service;

import com.spring.training.vo.Employeevo;

public interface EmployeeService {
	void create(Employeevo employee);

	void deleteEmployee(Long id);

	Employeevo displayEmployee(Long id);

	void updateEmployee(Long id, Employeevo obj);

	void testTransaction(Long id, Employeevo employee);
}
