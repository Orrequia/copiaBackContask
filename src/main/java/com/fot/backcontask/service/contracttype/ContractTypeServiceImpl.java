package com.fot.backcontask.service.contracttype;

import org.springframework.stereotype.Service;

import com.fot.backcontask.dao.ContractTypeDAO;
import com.fot.backcontask.exception.NotFoundException;
import com.fot.backcontask.model.ContractType;
import com.fot.backcontask.service.AbstractService;

@Service
public class ContractTypeServiceImpl extends AbstractService<ContractType, ContractTypeDAO> implements ContractTypeService {

	@Override
	public ContractType getAndCheck(Long id) throws NotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isEqual(ContractType u1, ContractType u2) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void setValues(ContractType to, ContractType from) {
		// TODO Auto-generated method stub
		
	}

}
