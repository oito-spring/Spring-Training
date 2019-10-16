package com.example.demo.dao.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.dao.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
