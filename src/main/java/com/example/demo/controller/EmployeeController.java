package com.example.demo.controller;

import org.slf4j.LoggerFactory;
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

import com.example.demo.controller.vo.Employeevo;
import com.example.demo.exceptionhandling.CustomException;
import com.example.demo.exceptionhandling.MethodNotAllowed;
import com.example.demo.training.EmployeeService;

@RestController
@RequestMapping("employee")
public class EmployeeController {
	@Autowired
	@Qualifier("EmployeeServiceImpl1")
	private EmployeeService employeeService;
	private static final org.slf4j.Logger logger = LoggerFactory.getLogger(EmployeeController.class);

	@GetMapping("/{id}")
	public ResponseEntity<Employeevo> get(@PathVariable Long id) throws CustomException {// GET
		Employeevo obj = null;
		if (id != null) {
			logger.info("Get Method in Controller successfully invoked!");
			obj = employeeService.view(id);

		} else {
			throw new MethodNotAllowed();
		}
		return ResponseEntity.ok(obj);
	}

	@PostMapping
	public void create(@RequestBody Employeevo obj) {// POST
		employeeService.create(obj);
		System.out.println("Printing from Controller : " + obj);

	}

	@PutMapping("/{id}")
	public void updateUser(@PathVariable Long id, @RequestBody Employeevo obj) {// PUT
		logger.info("Put method in controller is called.");
		System.out.println(obj);
		// employeeService.update(id, obj);
		employeeService.update1(id, obj);
	}

	@DeleteMapping("/{id}")
	public String deleteUser(@PathVariable Long id) {// DELETE
		employeeService.delete(id);
		return "Delete method in Controller is invoked";
	}
}
