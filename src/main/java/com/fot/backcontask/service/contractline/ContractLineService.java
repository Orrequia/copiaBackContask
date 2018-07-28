package com.fot.backcontask.service.contractline;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.fot.backcontask.exception.InvalidRequestException;
import com.fot.backcontask.exception.NotFoundException;
import com.fot.backcontask.model.ContractLine;
import com.fot.backcontask.service.Service;

public interface ContractLineService extends Service<ContractLine, Long> {
	
	ContractLine findOneContractLineByCompanyAndContract(Long idCompany, Long idContract, Long idContractLine) throws NotFoundException;
	List<ContractLine> findContractLineByCompanyAndContract(Long idCompany, Long idContract, Pageable p) throws NotFoundException;
	ContractLine addToContract(Long idContract, ContractLine contractLine) throws NotFoundException;
	void updateToContract(Long idCompany, Long idContract, Long idContractLine, ContractLine newContractLine) throws NotFoundException;
	void deleteToContract(Long idCompany, Long idContract, Long idCOntractLine, ContractLine bodyContractLine) throws NotFoundException, InvalidRequestException;
}
