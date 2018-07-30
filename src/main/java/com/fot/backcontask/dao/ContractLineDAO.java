package com.fot.backcontask.dao;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.fot.backcontask.model.ContractLine;

@Repository
public interface ContractLineDAO extends GenericDAO<ContractLine>{
	
	@Query(value = "SELECT conl FROM ContractLine AS conl JOIN Contract AS con JOIN Company AS c "
			+ "WHERE c.idCompany = :idCompany AND con.idContract = :idContract "
			+ "ORDER BY conl.idContractLine")
	List<ContractLine> findByCompanyAndContract(@Param("idCompany") Long idCompany, @Param("idContract") Long idContract, Pageable pageable);
}
