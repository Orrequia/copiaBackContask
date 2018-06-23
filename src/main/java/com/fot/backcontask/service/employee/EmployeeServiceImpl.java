package com.fot.backcontask.service.employee;

import org.springframework.stereotype.Service;

import com.fot.backcontask.dao.EmployeeDAO;
import com.fot.backcontask.model.Employee;
import com.fot.backcontask.service.AbstractService;

@Service
public class EmployeeServiceImpl extends AbstractService<Employee, EmployeeDAO> implements EmployeeService {

}
