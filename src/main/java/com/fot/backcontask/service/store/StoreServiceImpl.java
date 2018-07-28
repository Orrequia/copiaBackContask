package com.fot.backcontask.service.store;

import java.util.List;
import java.util.Optional;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.fot.backcontask.dao.StoreDAO;
import com.fot.backcontask.exception.InvalidRequestException;
import com.fot.backcontask.exception.NotFoundException;
import com.fot.backcontask.model.Company;
import com.fot.backcontask.model.Store;
import com.fot.backcontask.service.AbstractService;
import com.fot.backcontask.service.company.CompanyService;

@Service
public class StoreServiceImpl extends AbstractService<Store, StoreDAO> implements StoreService {

	@Autowired
	CompanyService companyService;
	
	@Override
	public Store getAndCheck(Long id) throws NotFoundException {
		return findById(id).orElseThrow(() -> new NotFoundException("La tienda no existe"));
	}

	@Override
	public boolean isEqual(Store s1, Store s2) {
		return StringUtils.equals(s1.getName(), s2.getName()) &&
				StringUtils.equals(s1.getEmail(), s2.getEmail()) &&
				StringUtils.equals(s1.getAddress(), s2.getAddress()) &&
				s1.getEmployee().equals(s2.getEmployee()) &&
				s1.getResponsible().equals(s2.getResponsible()) &&
				s1.getPopulation().equals(s2.getPopulation());
				
	}

	@Override
	public void setValues(Store to, Store from) {
		to.setName(from.getName());
		to.setEmail(from.getEmail());
		to.setAddress(from.getAddress());
		to.setEmployee(from.getEmployee());
		to.setResponsible(from.getResponsible());
		to.setPopulation(from.getPopulation());
	}
	
	@Override
	public Store findOneStoreByCompany(Long idCompany, Long idStore) throws NotFoundException {
		final Company company = companyService.getAndCheck(idCompany);
		return getAndCheckBelongCompany(company, idStore);
	}
	
	private Store getAndCheckBelongCompany(Company company, Long idStore) throws NotFoundException {
		final Optional<Store> store = company.getStore().stream()
				.filter(q -> q.getIdStore() == idStore)
				.findFirst();
		return store.orElseThrow(() -> new NotFoundException("Esta tienda no existe para esta empresa"));
	}
	
	@Override
	public List<Store> findStoreByCompany(Long idCourse, Pageable p) throws NotFoundException {
		companyService.getAndCheck(idCourse);
		return dao.findByCompany(idCourse, PageRequest.of(p.getPageNumber(), p.getPageSize()));
	}
	
	@Override
	public Store addToCompany(Long idCompany, Store store) throws NotFoundException {
		final Store createStore = create(store);
		companyService.addStore(companyService.getAndCheck(idCompany), createStore);
		return createStore;
	}
	
	@Override
	public void updateToCompany(Long idCompany, Long idStore, Store newStore) throws NotFoundException {
		final Company company = companyService.getAndCheck(idCompany);
		final Store store = this.getAndCheckBelongCompany(company, idStore);
		this.setValues(store, newStore);
		this.update(store);
	}
	
	@Override
	public void deleteToCompany(Long idCompany, Long idStore, Store bodyStore) throws NotFoundException, InvalidRequestException {
		final Company company = companyService.getAndCheck(idCompany);
		final Store store = this.getAndCheckBelongCompany(company, idStore);
		if(!this.isEqual(bodyStore, store))
			throw new InvalidRequestException("La tienda recibida no coincide con la almacenada");
		companyService.removeStore(company, store);
	}
}
