package com.fot.backcontask.controller;

import com.fot.backcontask.component.mapper.employee.EmployeeMapper;
import com.fot.backcontask.exception.InvalidRequestException;
import com.fot.backcontask.exception.NotFoundException;
import com.fot.backcontask.service.employee.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

import com.fot.backcontask.dto.employee.EmployeeDTO;
import com.fot.backcontask.model.Employee;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

@RestController
@RequestMapping("/employee")
class EmployeeController {

    private final EmployeeService employeeService;
    private final EmployeeMapper employeeMapper;

    @Autowired
    EmployeeController(EmployeeService employeeService, EmployeeMapper employeeMapper) {
        this.employeeService = employeeService;
        this.employeeMapper = employeeMapper;
    }

    @GetMapping
    public List<EmployeeDTO> findAll(@RequestParam(required = false) Long store,
                                     @RequestParam(defaultValue = "0", required= false ) Integer page,
                                     @RequestParam(defaultValue = "10", required= false ) Integer size) throws InvalidRequestException {
        List<Employee> models;
        if(store == null)
            models = employeeService.findAll(PageRequest.of(page, size));
        else
            models = employeeService.findByStore(store);
        return employeeMapper.modelToDto(models);
    }

    @GetMapping("/{id}")
    public EmployeeDTO findById(@PathVariable("id") Long id) throws NotFoundException {
        final Employee model = employeeService.getAndCheck(id);
        return employeeMapper.modelToDto(model);
    }

    @PostMapping
    public EmployeeDTO create(@RequestBody EmployeeDTO dto) throws InvalidRequestException, NotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        Method method = employeeMapper.dtoClazz().getMethod("getId" + employeeMapper.dtoClazz());
        if(method.invoke(dto) != null)
            throw new InvalidRequestException("El id no se puede recibir en el body");
        final Employee user = employeeMapper.dtoToModel(dto);
        final Employee createUser = employeeService.create(user);
        return employeeMapper.modelToDto(createUser);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable("id") Long id, @RequestBody EmployeeDTO dto) throws InvalidRequestException, NotFoundException, IllegalAccessException, InvocationTargetException, NoSuchMethodException {
        Method method = employeeMapper.dtoClazz().getMethod("getId" + employeeMapper.dtoClazz());
        if(method.invoke(dto) != null)
            throw new InvalidRequestException("El id no se puede recibir en el body");
        final Employee model = employeeService.getAndCheck(id);
        employeeService.setValues(model, employeeMapper.dtoToModel(dto));
        employeeService.update(model);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id, @RequestBody EmployeeDTO dto) throws InvalidRequestException, NotFoundException {
        final Employee model = employeeService.getAndCheck(id);
        if(!employeeService.isEqual(employeeMapper.dtoToModel(dto), model))
            throw new InvalidRequestException("El " + employeeMapper.modelClazz() + " recibido no coincide con el almacenado");
        employeeService.delete(model);
    }
}
