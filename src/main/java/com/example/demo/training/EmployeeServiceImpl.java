package com.example.demo.training;

import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import com.example.demo.controller.vo.Employeevo;

@Component
//@Service
@Primary
public class EmployeeServiceImpl implements EmployeeService {
	private static final org.slf4j.Logger logger = LoggerFactory.getLogger(EmployeeServiceImpl.class);

	public EmployeeServiceImpl() {
		logger.info("################Employee Service Impl###################");
	}

	@Override
	public void create(Employeevo employee) {// POST
		logger.info("Service created");
	}

	@Override
	public void delete(Long id) {// DELETE

	}

	@Override
	public Employeevo view(Long id) {// GET
		return null;

	}

	@Override
	public void update(Long id, Employeevo obj) {// PUT

	}

	@Override
	public void update1(Long id, Employeevo obj) {
		// TODO Auto-generated method stub

	}

}
