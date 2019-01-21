package com.fot.backcontask.component.mapper.store;

import com.fot.backcontask.exception.NotFoundException;
import com.fot.backcontask.model.*;
import com.fot.backcontask.service.dongle.DongleService;
import com.fot.backcontask.service.employee.EmployeeService;
import com.fot.backcontask.service.population.PopulationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fot.backcontask.component.mapper.AbstractMapper;
import com.fot.backcontask.dto.store.StoreDTO;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class StoreMapperImpl extends AbstractMapper<Store, StoreDTO> implements StoreMapper {

	private final PopulationService populationService;
	private final EmployeeService employeeService;
	private final DongleService dongleService;

	@Autowired
	public StoreMapperImpl(PopulationService populationService, EmployeeService employeeService,
						   DongleService dongleService) {
		this.populationService = populationService;
		this.employeeService = employeeService;
		this.dongleService = dongleService;
	}

	@Override
	public Class<? extends StoreDTO> dtoClazz() {
		return StoreDTO.class;
	}

	@Override
	public Class<? extends Store> modelClazz() {
		return Store.class;
	}

	@Override
	public Store dtoToModel(StoreDTO dto) throws NotFoundException {
		return map(dto, longToEmployee(dto.getEmployees()), longToDongle(dto.getDongles()));
	}

	private Store map(StoreDTO dto, final List<Employee> employee, final List<Dongle> dongle) throws NotFoundException {
		Store store = dozer.map(dto, modelClazz());
		store.setEmployee(employee);
		store.setDongle(dongle);
		if(dto.getIdPopulation() != null) store.setPopulation(populationService.getAndCheck(dto.getIdPopulation()));
		if(dto.getIdResponsible() != null) store.setResponsible(employeeService.getAndCheck(dto.getIdResponsible()));
		return store;
	}

	private List<Employee> longToEmployee(final List<Long> employees) throws NotFoundException {
		if(employees != null) {
			List<Employee> employee = employees.stream().map(employeeService::findById)
					.filter(Optional::isPresent)
					.map(Optional::get)
					.collect(Collectors.toList());
			if(employees.size() != employee.size()) throw new NotFoundException("Algunos o todos los empleados no existen");
			return employee;
		}
		return new ArrayList<>();
	}

	private List<Dongle> longToDongle(final List<Long> dongles) throws NotFoundException {
		if(dongles != null) {
			List<Dongle> dongle = dongles.stream().map(dongleService::findById)
					.filter(Optional::isPresent)
					.map(Optional::get)
					.collect(Collectors.toList());
			if(dongles.size() != dongle.size()) throw new NotFoundException("Algunos o todas las mochilas no existen");
			return dongle;
		}
		return new ArrayList<>();
	}

	@Override
	public StoreDTO modelToDto(Store model) {
		return map(model, employeeToLong(model.getEmployee()));
	}

	private List<Long> employeeToLong(final List<Employee> employee) {
		return employee.stream().map(Employee::getIdEmployee).collect(Collectors.toList());
	}

	private StoreDTO map(Store model, final List<Long> employees) {
		StoreDTO storeDTO = dozer.map(model, dtoClazz());
		storeDTO.setIdPopulation(model.getPopulation().getIdPopulation());
		storeDTO.setIdResponsible(model.getResponsible().getIdEmployee());
		storeDTO.setEmployees(employees);
		return storeDTO;
	}
}
