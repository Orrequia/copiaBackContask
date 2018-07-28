package com.fot.backcontask.service.contract;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.fot.backcontask.exception.InvalidRequestException;
import com.fot.backcontask.exception.NotFoundException;
import com.fot.backcontask.model.Contract;
import com.fot.backcontask.model.ContractLine;
import com.fot.backcontask.service.Service;

public interface ContractService extends Service<Contract, Long>{
	
	Contract findOneContractByCompany(Long idCompany, Long idContract) throws NotFoundException;
	List<Contract> findContractByCompany(Long idCompany, Pageable p) throws NotFoundException;
	Contract addToCompany(Long idCompany, Contract contract) throws NotFoundException;
	void updateToCompany(Long idCompany, Long idContract, Contract newContract) throws NotFoundException;
	void deleteToCompany(Long idCompany, Long idContract, Contract bodyContract) throws NotFoundException, InvalidRequestException;
	
	void addContractLine(Contract contract, ContractLine contractLine);
	void removeContractLine(Contract contract, ContractLine contractLine);
}
