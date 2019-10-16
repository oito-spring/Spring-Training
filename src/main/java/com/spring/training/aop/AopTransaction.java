package com.spring.training.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class AopTransaction {
	@Pointcut("execution(* com.spring.training.dao.EmployeeDaoImpl.create(..))")
	public void create() {
		System.out.println("Hi");
	}

	@Before("create(Employeevo employee)")
	public void show() {
		System.out.println("New Employee Created (Aspect MSG):");
	}
}
