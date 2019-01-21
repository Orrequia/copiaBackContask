package com.fot.backcontask.controller;

import com.fot.backcontask.component.mapper.company.CompanyMapper;
import com.fot.backcontask.exception.InvalidRequestException;
import com.fot.backcontask.exception.NotFoundException;
import com.fot.backcontask.service.company.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

import com.fot.backcontask.dto.company.CompanyDTO;
import com.fot.backcontask.model.Company;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

@RestController
@RequestMapping("/company")
class CompanyController {

    private final CompanyService companyService;
    private final CompanyMapper companyMapper;

    @Autowired
    CompanyController(CompanyService employeeService, CompanyMapper employeeMapper) {
        this.companyService = employeeService;
        this.companyMapper = employeeMapper;
    }

    @GetMapping
    public List<CompanyDTO> findAll(@RequestParam(required = false) String freeSearch,
                                     @RequestParam(defaultValue = "0", required= false ) Integer page,
                                     @RequestParam(defaultValue = "10", required= false ) Integer size) throws InvalidRequestException {
        List<Company> models;
        if(freeSearch == null)
            models = companyService.findAll(PageRequest.of(page, size));
        else
            models = companyService.freeSearchCompanies(freeSearch);

        return companyMapper.modelToDto(models);
    }

    @GetMapping("/{id}")
    public CompanyDTO findById(@PathVariable("id") Long id) throws NotFoundException {
        final Company model = companyService.getAndCheck(id);
        return companyMapper.modelToDto(model);
    }

    @PostMapping
    public CompanyDTO create(@RequestBody CompanyDTO dto) throws InvalidRequestException, NotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        Method method = companyMapper.dtoClazz().getMethod("getId" + companyMapper.dtoClazz());
        if(method.invoke(dto) != null)
            throw new InvalidRequestException("El id no se puede recibir en el body");
        final Company user = companyMapper.dtoToModel(dto);
        final Company createUser = companyService.create(user);
        return companyMapper.modelToDto(createUser);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable("id") Long id, @RequestBody CompanyDTO dto) throws InvalidRequestException, NotFoundException, IllegalAccessException, InvocationTargetException, NoSuchMethodException {
        Method method = companyMapper.dtoClazz().getMethod("getId" + companyMapper.dtoClazz());
        if(method.invoke(dto) != null)
            throw new InvalidRequestException("El id no se puede recibir en el body");
        final Company model = companyService.getAndCheck(id);
        companyService.setValues(model, companyMapper.dtoToModel(dto));
        companyService.update(model);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id, @RequestBody CompanyDTO dto) throws InvalidRequestException, NotFoundException {
        final Company model = companyService.getAndCheck(id);
        if(!companyService.isEqual(companyMapper.dtoToModel(dto), model))
            throw new InvalidRequestException("El " + companyMapper.modelClazz() + " recibido no coincide con el almacenado");
        companyService.delete(model);
    }
}
