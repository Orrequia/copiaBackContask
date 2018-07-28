package com.fot.backcontask.dao;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.fot.backcontask.model.Contract;
import com.fot.backcontask.model.Store;

@Repository
public interface ContractDAO extends GenericDAO<Contract>{
	
	@Query(value = "SELECT con FROM Contract AS con JOIN Company AS c WHERE c.idCompany = :idCompany ORDEN BY con.finishDate")
	List<Store> findByCompany(@Param("idCompany") Long idCompany, Pageable pageable);
}
