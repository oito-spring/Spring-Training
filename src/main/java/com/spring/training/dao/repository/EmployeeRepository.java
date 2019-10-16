package com.spring.training.dao.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.training.dao.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
