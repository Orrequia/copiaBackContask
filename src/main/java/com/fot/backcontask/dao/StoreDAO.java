package com.fot.backcontask.dao;

import java.util.List;

import com.fot.backcontask.model.Company;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.fot.backcontask.model.Store;

@Repository
public interface StoreDAO extends GenericDAO<Store> {

	@Query(value = "SELECT s FROM Company AS c JOIN c.store AS s WHERE c.idCompany = :idCompany ORDER BY s.name")
	List<Store> findByCompany(@Param("idCompany") Long idCompany, Pageable pageable);
}
