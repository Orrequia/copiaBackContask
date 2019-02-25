package com.fot.backcontask.dao;

import com.fot.backcontask.model.Store;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StoreDAO extends GenericDAO<Store> {

	@Query(value = "SELECT s FROM Company AS c JOIN c.store AS s WHERE c.idCompany = :idCompany ORDER BY s.name")
	List<Store> findByCompany(@Param("idCompany") Long idCompany);
}
