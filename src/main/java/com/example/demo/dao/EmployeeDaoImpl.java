package com.example.demo.dao;

import java.util.Optional;

import javax.transaction.Transactional;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.controller.vo.Employeevo;
import com.example.demo.controller.vo.mapping.MappingInterface;
import com.example.demo.dao.entity.Employee;
import com.example.demo.dao.repository.EmployeeRepository;
import com.example.demo.exceptionhandling.CustomException;
import com.example.demo.exceptionhandling.RecordNotFound;

@SuppressWarnings("serial")
@Component
public class EmployeeDaoImpl extends CustomException implements EmployeeDao {
	@Autowired
	private EmployeeRepository employeeRepository;
	@Autowired
	private MappingInterface mappingObj;
	private static final org.slf4j.Logger logger = LoggerFactory.getLogger(EmployeeDaoImpl.class);

	public EmployeeDaoImpl() {
		logger.info("DAO Constructor invoked");
	}

	@Override
	@Transactional
	public void transactionTest(Long id, Employeevo employee) {
		// create(employee);
		final Employee emp = new Employee();
		emp.setName("Arjun");
		emp.setAge(27);
		emp.setSalary(70000);
		emp.setAddress("Knr");
		employeeRepository.save(emp);
		update(id, employee);

	}

	@Override
	public void create(Employeevo employee) {// POST
		try {
			logger.info("Dao class create method invoked.");
			logger.info("Calling MappingInterface");
			final Employee emp = mappingObj.employeeReverseMap(employee);
			logger.info("Called MappingInterface");
			employeeRepository.saveAndFlush(emp);
			logger.info("New Employee Created");

		} catch (final Exception c) {
			logger.info(c.getMessage());
		}
	}

	@Override
	public void delete(Long id) throws CustomException {// DELETE
		employeeRepository.deleteById(id);
	}

	@Override
	public Employeevo view(Long id) throws CustomException {// GET
		/*
		 * if (id == null) { throw new MethodNotAllowed(); }
		 */
		final Employeevo employee = new Employeevo();
		final Optional<Employee> temp = employeeRepository.findById(id);// findById retrieves an entity by its id
		logger.info("Dao class get/view method invoked");
		if (temp.isPresent()) {
			final Employee emp = temp.get();
			employee.setName(emp.getName());
			employee.setAge(emp.getAge());
			employee.setSalary(emp.getSalary());
			employee.setAddress(emp.getAddress());
		} else {
			throw new RecordNotFound();
		}
		return employee;
	}

	@Override
	public void update(Long id, Employeevo obj) {// PUT
		logger.info("Dao class put method invoked");
		final Optional<Employee> temp = employeeRepository.findById(id);
		if (temp.isPresent()) {
			final Employee emp = temp.get();
			emp.setName(obj.getName());
			emp.setAge(obj.getAge());
			emp.setSalary(obj.getSalary());
			emp.setAddress(obj.getAddress());
			employeeRepository.saveAndFlush(emp);// saveAndFlush saves and commits the data
			logger.info("Dao class put method executed successfully");
		} else {
			throw new RecordNotFound();
		}
	}

}
