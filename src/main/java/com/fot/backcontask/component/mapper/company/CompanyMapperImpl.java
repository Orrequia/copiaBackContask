package com.fot.backcontask.component.mapper.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fot.backcontask.component.mapper.AbstractMapper;
import com.fot.backcontask.dto.company.CompanyDTO;
import com.fot.backcontask.exception.NotFoundException;
import com.fot.backcontask.model.Company;
import com.fot.backcontask.model.Contract;
import com.fot.backcontask.model.Store;
import com.fot.backcontask.service.companytype.CompanyTypeService;
import com.fot.backcontask.service.contract.ContractService;
import com.fot.backcontask.service.employee.EmployeeService;
import com.fot.backcontask.service.store.StoreService;

@Component
public class CompanyMapperImpl extends AbstractMapper<Company, CompanyDTO> implements CompanyMapper {

	@Autowired
	StoreService storeService;
	
	@Autowired
	ContractService contractService;
	
	@Autowired
	EmployeeService employeeService;
	
	@Autowired
	CompanyTypeService companyTypeService;
	
	@Override
	public Class<? extends CompanyDTO> dtoClazz() {
		return CompanyDTO.class;
	}

	@Override
	public Class<? extends Company> modelClazz() {
		return Company.class;
	}
	
	@Override
	public Company dtoToModel(CompanyDTO dto) throws NotFoundException {
		return map(dto, longToStore(dto.getStores()), longToContract(dto.getContracts()));
	}
	
	private Company map(CompanyDTO dto, final List<Store> store, final List<Contract> contract) throws NotFoundException {
		Company company = dozer.map(dto, modelClazz());
		company.setStore(store);
		company.setContract(contract);
		if(dto.getIdOwner() != null) company.setOwner(employeeService.getAndCheck(dto.getIdOwner()));
		if(dto.getIdCompanyType() != null) company.setCompanyType(companyTypeService.getAndCheck(dto.getIdCompanyType()));
		return company;
	}
	
	private List<Store> longToStore(final List<Long> stores) throws NotFoundException {
		if(stores != null) {
			List<Store> store = stores.stream().map(storeService::findById)
					.filter(Optional::isPresent)
					.map(Optional::get)
					.collect(Collectors.toList());
			if(store.size() != stores.size()) throw new NotFoundException("Algunas o todas las tiendas no existen");
			return store;
		}
		return new ArrayList<>();
	}
	
	private List<Contract> longToContract(final List<Long> contracts) throws NotFoundException {
		if(contracts != null) {
			List<Contract> contract = contracts.stream().map(contractService::findById)
					.filter(Optional::isPresent)
					.map(Optional::get)
					.collect(Collectors.toList());
			if(contract.size() != contracts.size()) throw new NotFoundException("Algunos o todos los contratos no existen");
			return contract;
		}
		return new ArrayList<>();
	}

	@Override
	public CompanyDTO modelToDto(Company model) {
		return map(model, storeToLong(model.getStore()), contractToLong(model.getContract()));
	}
	
	private List<Long> storeToLong(final List<Store> store) {
		return store.stream().map(Store::getIdStore).collect(Collectors.toList());
	}
	
	private List<Long> contractToLong(final List<Contract> contract) {
		return contract.stream().map(Contract::getIdContract).collect(Collectors.toList());
	}
	
	private CompanyDTO map(Company model, final List<Long> stores, final List<Long> contracts) {
		CompanyDTO companyDTO = dozer.map(model, dtoClazz());
		companyDTO.setIdOwner(model.getOwner().getIdEmployee());
		companyDTO.setIdCompanyType(model.getCompanyType().getIdCompanyType());
		companyDTO.setStores(stores);
		companyDTO.setContracts(contracts);
		return companyDTO;
	}
}
