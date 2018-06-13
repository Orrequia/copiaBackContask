package com.fot.backConTask.service.employee;

import org.springframework.stereotype.Service;

import com.fot.backConTask.dao.EmployeeDAO;
import com.fot.backConTask.model.Employee;
import com.fot.backConTask.service.AbstractService;

@Service
public class EmployeeServiceImpl extends AbstractService<Employee, EmployeeDAO> implements EmployeeService {

}
