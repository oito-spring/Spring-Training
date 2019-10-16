package com.example.demo.training;

import com.example.demo.controller.vo.Employeevo;
import com.example.demo.exceptionhandling.CustomException;

public interface EmployeeService {
	void create(Employeevo employee);

	void delete(Long id);

	Employeevo view(Long id) throws CustomException;

	void update(Long id, Employeevo obj);

	void update1(Long id, Employeevo obj);
}
