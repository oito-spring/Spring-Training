package com.example.demo.dao;

import com.example.demo.controller.vo.Employeevo;
import com.example.demo.exceptionhandling.CustomException;

public interface EmployeeDao {
	void create(Employeevo employee);

	Employeevo view(Long id) throws CustomException;

	void delete(Long id) throws CustomException;

	void update(Long id, Employeevo obj) throws CustomException;

	void transactionTest(Long id, Employeevo obj);
}
