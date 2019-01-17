package com.fot.backcontask.service.employee;

import com.fot.backcontask.model.Employee;
import com.fot.backcontask.service.Service;

import java.util.List;

public interface EmployeeService extends Service<Employee, Long> {

    List<Employee> findByStore(Long store);
}
