package com.fot.backcontask.service.company;

import org.apache.commons.codec.binary.StringUtils;
import org.springframework.stereotype.Service;

import com.fot.backcontask.dao.CompanyDAO;
import com.fot.backcontask.exception.NotFoundException;
import com.fot.backcontask.model.Company;
import com.fot.backcontask.model.Contract;
import com.fot.backcontask.model.Store;
import com.fot.backcontask.service.AbstractService;

import java.util.*;

@Service
public class CompanyServiceImpl extends AbstractService<Company, CompanyDAO> implements CompanyService {

	@Override
	public Company getAndCheck(Long id) throws NotFoundException {
		return findById(id).orElseThrow(() -> new NotFoundException("La empresa no existe"));
	}

	@Override
	public boolean isEqual(Company c1, Company c2) {
		return StringUtils.equals(c1.getName(), c2.getName()) &&
				StringUtils.equals(c1.getNif(), c2.getNif()) &&
				StringUtils.equals(c1.getNote(), c2.getNote()) &&
				c1.getOwner().getIdEmployee().equals(c2.getOwner().getIdEmployee()) &&

				c1.getStore().stream().allMatch(store ->
							c2.getStore().stream().anyMatch(store2 -> store.getIdStore().equals(store2.getIdStore()))) &&
				c2.getStore().stream().allMatch(store ->
							c1.getStore().stream().anyMatch(store2 -> store.getIdStore().equals(store2.getIdStore()))) &&

				c1.getContract().stream().allMatch(contract ->
						c2.getContract().stream().anyMatch(contract2 -> contract.getIdContract().equals(contract2.getIdContract()))) &&
				c2.getContract().stream().allMatch(contract ->
						c1.getContract().stream().anyMatch(contract2 -> contract.getIdContract().equals(contract2.getIdContract()))) &&

				c1.getCompanyType().getIdCompanyType().equals(c2.getCompanyType().getIdCompanyType());
	}

	@Override
	public void setValues(Company to, Company from) {
		to.setName(from.getName());
		to.setNif(from.getNif());
		to.setNote(from.getNote());
		to.setOwner(from.getOwner());
		to.setStore(from.getStore());
		to.setContract(from.getContract());
		to.setCompanyType(from.getCompanyType());
	}

	@Override
	public void addStore(Company company, Store store) {
		company.getStore().add(store);
		dao.save(company);
	}
	
	@Override
	public void removeStore(Company company, Store store) {
		company.getStore().remove(store);
		dao.save(company);
	}
	
	@Override
	public void addContract(Company company, Contract contract) {
		company.getContract().add(contract);
		dao.save(company);
	}

	@Override
	public void removeContract(Company company, Contract contract) {
		company.getContract().remove(contract);
		dao.save(company);
	}

	@Override
	public List<Company> freeSearchCompanies(String freeSearch) {
		freeSearch = freeSearch.toLowerCase();
		Set<Company> wanted = searchInCompany(freeSearch);
		wanted.addAll(dao.findByStoreFields(freeSearch, freeSearch, freeSearch));
		wanted.addAll(dao.findByEmployeeFields(freeSearch, freeSearch));
		wanted.addAll(dao.findByOwnerFields(freeSearch, freeSearch));
		return new ArrayList<>(wanted);
	}

	private Set<Company> searchInCompany(String freeSearch) {
		return new HashSet<>(dao.findByNameContainingIgnoreCaseOrNifContainingIgnoreCaseOrNoteContainingIgnoreCase(freeSearch, freeSearch, freeSearch));
	}
}
