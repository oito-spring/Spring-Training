package com.spring.training.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

import com.spring.training.vo.Employeevo;

@Aspect
public class TrackEmployee {

	@Pointcut("execution(* com.spring.training.dao.EmployeeDaoImpl.create(..))")
	public void create(Employeevo employee) {
	}

	@Before("create(Employeevo employee)")
	public void show() {
		System.out.println("New Employee Created (Aspect MSG):");
	}

}
