package com.fot.backcontask.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fot.backcontask.dto.employee.EmployeeDTO;
import com.fot.backcontask.model.Employee;

@RestController
@RequestMapping("/employee")
public class EmployeeController extends AbstractController<Employee, EmployeeDTO>{

}
