package com.fot.backcontask.service.store;

import com.fot.backcontask.dao.StoreDAO;
import com.fot.backcontask.exception.InvalidRequestException;
import com.fot.backcontask.exception.NotFoundException;
import com.fot.backcontask.model.Company;
import com.fot.backcontask.model.Store;
import com.fot.backcontask.service.AbstractService;
import com.fot.backcontask.service.company.CompanyService;
import lombok.AllArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
@AllArgsConstructor(onConstructor_={@Autowired})
public class StoreServiceImpl extends AbstractService<Store, StoreDAO> implements StoreService {

	final private CompanyService companyService;
	
	@Override
	public Store getAndCheck(Long id) throws NotFoundException {
		return findById(id).orElseThrow(() -> new NotFoundException("La tienda no existe"));
	}

	@Override
	public boolean isEqual(Store s1, Store s2) {
		return StringUtils.equals(s1.getName(), s2.getName()) &&
				StringUtils.equals(s1.getEmail(), s2.getEmail()) &&
				StringUtils.equals(s1.getAddress(), s2.getAddress()) &&
				s1.getResponsible().getIdEmployee().equals(s2.getResponsible().getIdEmployee()) &&
				s1.getPopulation().getIdPopulation().equals(s2.getPopulation().getIdPopulation()) &&

				s1.getEmployee().stream().allMatch(employee ->
						s2.getEmployee().stream().anyMatch(employee2 ->
								employee.getIdEmployee().equals(employee2.getIdEmployee()))) &&
				s2.getEmployee().stream().allMatch(employee ->
						s1.getEmployee().stream().anyMatch(employee2 ->
								employee.getIdEmployee().equals(employee2.getIdEmployee())));

	}

	@Override
	public void setValues(Store to, Store from) {
		to.setName(from.getName());
		to.setEmail(from.getEmail());
		to.setAddress(from.getAddress());
		to.setResponsible(from.getResponsible());
		to.setPopulation(from.getPopulation());
		to.setEmployee(from.getEmployee());
	}
	
	@Override
	public Store findOneStoreByCompany(Long idCompany, Long idStore) throws NotFoundException {
		final Company company = companyService.getAndCheck(idCompany);
		return getAndCheckBelongCompany(company, idStore);
	}
	
	private Store getAndCheckBelongCompany(Company company, Long idStore) throws NotFoundException {
		final Optional<Store> store = company.getStore().stream()
				.filter(q -> Objects.equals(q.getIdStore(), idStore))
				.findFirst();
		return store.orElseThrow(() -> new NotFoundException("Esta tienda no existe para esta empresa"));
	}
	
	@Override
	public List<Store> findStoreByCompany(Long idCompany) throws NotFoundException {
		companyService.getAndCheck(idCompany);
		return dao.findByCompany(idCompany);
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
