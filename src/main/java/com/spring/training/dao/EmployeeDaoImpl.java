package com.spring.training.dao;

import java.util.Optional;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.spring.training.dao.entity.Employee;
import com.spring.training.dao.repository.EmployeeRepository;
import com.spring.training.exceptionhandler.EmployeeNotFound;
import com.spring.training.exceptionhandler.ExceptionController;
import com.spring.training.vo.Employeevo;
import com.spring.training.vo.mapping.EmployeeMapper;

@Component
public class EmployeeDaoImpl extends ExceptionController implements EmployeeDao {

	private final static Logger logger = Logger.getLogger(EmployeeDaoImpl.class.getName());
	@Autowired
	private EmployeeRepository employeeRepository;
	@Autowired
	private EmployeeMapper employeeMapper;

	public EmployeeDaoImpl() {
		System.out.println(" Dao object");
	}

	@Override
	@Transactional
	public void transactionTest(Long id, Employeevo employee) {
		final Employee emp = new Employee();
		emp.setName("Arjun");
		emp.setAge(28);
		emp.setAddress("ushusdh");
		emp.setSalary(80000);
		employeeRepository.save(emp);
		updateEmployee(id, employee);
	}

	@Override
	public void create(Employeevo employee) {

		final Employee emp = employeeMapper.employeeConversion(employee);
		System.out.println("Dao class");
		logger.info("Log: Dao class");
		System.out.println("New Employee Created :  " + emp.getName() + " " + emp.getAge() + " " + emp.getSalary());
		employeeRepository.save(emp);
	}

	@Override
	public void deleteEmployee(Long id) {
		employeeRepository.deleteById(id);

	}

	@Override
	public Employeevo displayEmployee(Long id) {

		final Optional<Employee> empOptional = employeeRepository.findById(id);

		if (empOptional.isPresent()) {

		} else {
			throw new EmployeeNotFound();
		}

		final Employee employeeValues = empOptional.get();
		final Employeevo employee = new Employeevo();
		employee.setEmpname(employeeValues.getName());
		employee.setAge(employeeValues.getAge());
		employee.setSalary(employeeValues.getSalary());
		employee.setAddress(employeeValues.getAddress());

		return employee;
	}

	@Override
	public void updateEmployee(Long id, Employeevo obj) {
		final Employee employee = employeeRepository.getOne(id);
		employee.setSalary(obj.getSalary());
		employee.setAddress(obj.getAddress());
		employee.setAge(obj.getAge());
		employee.setName(obj.getEmpname());
		employeeRepository.save(employee);
	}

}
