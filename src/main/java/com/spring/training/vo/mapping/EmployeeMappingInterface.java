package com.spring.training.vo.mapping;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.spring.training.dao.entity.Employee;
import com.spring.training.vo.EmployeeVO;

@Mapper(componentModel = "spring")
public interface EmployeeMappingInterface {
	EmployeeMappingInterface INSTANCE = Mappers.getMapper(EmployeeMappingInterface.class);

	@Mapping(source = "name", target = "name")
	@Mapping(source = "salary", target = "salary")
	@Mapping(source = "age", target = "age")
	@Mapping(source = "address", target = "address")
	EmployeeVO employeeConvertion(Employee employee);

	@InheritInverseConfiguration
	Employee reConvertion(EmployeeVO employeeVO);
}
