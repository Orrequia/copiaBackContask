package com.fot.backcontask.service.store;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.fot.backcontask.exception.InvalidRequestException;
import com.fot.backcontask.exception.NotFoundException;
import com.fot.backcontask.model.Store;
import com.fot.backcontask.service.Service;

public interface StoreService extends Service<Store, Long> {

	Store findOneStoreByCompany(Long idCompany, Long idStore) throws NotFoundException;
	List<Store> findStoreByCompany(Long idCourse, Pageable p) throws NotFoundException;
	Store addToCompany(Long idCompany, Store store) throws NotFoundException;
	void updateToCompany(Long idCompany, Long idStore, Store newStore) throws NotFoundException;
	void deleteToCompany(Long idCompany, Long idStore, Store bodyStore) throws NotFoundException, InvalidRequestException;
}
