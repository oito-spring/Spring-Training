package com.spring.training.service;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import com.spring.training.vo.Employeevo;

@Component
@Primary
public class EmployeeServiceImpl1 implements EmployeeService {
	public EmployeeServiceImpl1() {
		System.out.println("########################################################: EmployeeServiceImpl1");
	}

	@Override
	public void create(Employeevo employee) {
		System.out.println("service created   2");
	}

	@Override
	public void deleteEmployee(Long id) {
		// TODO Auto-generated method stub

	}

	@Override
	public Employeevo displayEmployee(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateEmployee(Long id, Employeevo obj) {
		// TODO Auto-generated method stub

	}

	@Override
	public void testTransaction(Long id, Employeevo employee) {
		// TODO Auto-generated method stub

	}

}
