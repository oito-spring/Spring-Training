package com.example.demo.training;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.example.demo.controller.vo.Employeevo;
import com.example.demo.dao.EmployeeDao;
import com.example.demo.exceptionhandling.CustomException;

@Component
@Qualifier("EmployeeServiceImpl1")
public class EmployeeServiceImpl1 implements EmployeeService {
	@Autowired
	private EmployeeDao daoobj;
	private static final org.slf4j.Logger logger = LoggerFactory.getLogger(EmployeeServiceImpl1.class);

	public EmployeeServiceImpl1() {
		logger.info("################Employee Service Impl1###################");
	}

	@Override
	public void create(Employeevo employee) {// POST
		logger.info("Service created 1");
		daoobj.create(employee);
	}

	@Override
	public void delete(Long id) {// DELETE
		logger.info("Delete method in service class invoked!");
		try {
			daoobj.delete(id);
		} catch (final CustomException e) {

			e.printStackTrace();
		}
	}

	@Override
	public Employeevo view(Long id) throws CustomException {// GET
		logger.info("Get method in service class invoked!");

		return daoobj.view(id);

	}

	@Override
	public void update(Long id, Employeevo obj) {// PUT
		logger.info("Put/update method in service class invoked!");
		try {
			daoobj.update(id, obj);
		} catch (final CustomException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void update1(Long id, Employeevo obj) {// PUT
		logger.info("Put/update method in service class invoked!");
		daoobj.transactionTest(id, obj);
	}
}
