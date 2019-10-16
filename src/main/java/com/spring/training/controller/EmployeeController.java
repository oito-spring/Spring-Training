package com.spring.training.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.training.service.EmployeeService;
import com.spring.training.vo.Employeevo;

@RestController
@RequestMapping("employee")
public class EmployeeController {

	private String name;
	@Autowired // fetch object
	// @Primary
	@Qualifier("employeeServiceImpl")
	private EmployeeService employeeService;

	@GetMapping("/{id}")
	public ResponseEntity<Employeevo> get(@PathVariable Long id) {
		final Employeevo employeevo = employeeService.displayEmployee(id);
		return ResponseEntity.ok(employeevo);
	}

	@PostMapping
	public void create(@RequestBody Employeevo obj) {
		System.out.println("In POST");
		employeeService.create(obj);

	}

	@PutMapping("/{id}")
	public void updateUser(@PathVariable Long id, @RequestBody Employeevo obj) {
		employeeService.updateEmployee(id, obj);
		// employeeService.testTransaction(id, obj);
	}

	@DeleteMapping("/{id}")
	public String deleteUser(@PathVariable Long id) {

		employeeService.deleteEmployee(id);
		return "HTTP DELETE was called";
	}

}
