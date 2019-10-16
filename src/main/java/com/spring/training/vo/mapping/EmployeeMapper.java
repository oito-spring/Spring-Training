package com.spring.training.vo.mapping;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import com.spring.training.dao.entity.Employee;
import com.spring.training.vo.Employeevo;

@Mapper(componentModel = "spring")
public interface EmployeeMapper {

	EmployeeMapper mapper = Mappers.getMapper(EmployeeMapper.class);

	@Mappings({ @Mapping(source = "empname", target = "name"), @Mapping(source = "salary", target = "salary"),
			@Mapping(source = "age", target = "age"), @Mapping(source = "address", target = "address") })
	Employee employeeConversion(Employeevo employee);

	@InheritInverseConfiguration
	Employeevo employeeReConversion(Employee employee);
}
