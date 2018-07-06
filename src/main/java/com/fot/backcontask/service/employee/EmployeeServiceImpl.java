package com.fot.backcontask.service.employee;

import org.springframework.stereotype.Service;

import com.fot.backcontask.dao.EmployeeDAO;
import com.fot.backcontask.exception.NotFoundException;
import com.fot.backcontask.model.Employee;
import com.fot.backcontask.service.AbstractService;

@Service
public class EmployeeServiceImpl extends AbstractService<Employee, EmployeeDAO> implements EmployeeService {

	@Override
	public Employee getAndCheck(Long id) throws NotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isEqual(Employee u1, Employee u2) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void setValues(Employee to, Employee from) {
		// TODO Auto-generated method stub
		
	}

}
