package com.example.demo.controller.vo.mapping;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import com.example.demo.controller.vo.Employeevo;
import com.example.demo.dao.entity.Employee;

@Mapper(componentModel = "spring")
public interface MappingInterface {
	MappingInterface INSTANCE = Mappers.getMapper(MappingInterface.class);

	@Mappings({ @Mapping(source = "name", target = "name"), @Mapping(source = "salary", target = "salary"),
			@Mapping(source = "age", target = "age"), @Mapping(source = "address", target = "address") })
	Employeevo employeeMap(Employee employee);

	@InheritInverseConfiguration
	Employee employeeReverseMap(Employeevo employeevo);
}
