package com.fot.backcontask.component.mapper.employee;

import org.springframework.stereotype.Component;

import com.fot.backcontask.component.mapper.AbstractMapper;
import com.fot.backcontask.dto.employee.EmployeeDTO;
import com.fot.backcontask.model.Employee;

@Component
public class EmployeeMapperImpl extends AbstractMapper<Employee, EmployeeDTO> implements EmployeeMapper {

	@Override
	public Class<? extends EmployeeDTO> dtoClazz() {
		return EmployeeDTO.class;
	}

	@Override
	public Class<? extends Employee> modelClazz() {
		return Employee.class;
	}

}
