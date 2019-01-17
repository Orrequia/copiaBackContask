package com.fot.backcontask.service.employee;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import com.fot.backcontask.dao.EmployeeDAO;
import com.fot.backcontask.exception.NotFoundException;
import com.fot.backcontask.model.Employee;
import com.fot.backcontask.service.AbstractService;

import java.util.List;

@Service
public class EmployeeServiceImpl extends AbstractService<Employee, EmployeeDAO> implements EmployeeService {

	@Override
	public Employee getAndCheck(Long id) throws NotFoundException {
		return findById(id).orElseThrow(() -> new NotFoundException("El trabajador no existe"));
	}

	@Override
	public boolean isEqual(Employee e1, Employee e2) {
		return StringUtils.equals(e1.getName(), e2.getName()) &&
				StringUtils.equals(e1.getEmail(), e2.getEmail()) &&
				StringUtils.equals(e1.getPhone(), e2.getPhone());
	}

	@Override
	public void setValues(Employee to, Employee from) {
		to.setName(from.getName());
		to.setEmail(from.getEmail());
		to.setPhone(from.getPhone());
	}

	@Override
	public List<Employee> findByStore(Long store) {
		return dao.findByStore(store);
	}
}
