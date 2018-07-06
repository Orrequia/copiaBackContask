package com.fot.backcontask.service.contract;

import org.springframework.stereotype.Service;

import com.fot.backcontask.dao.ContractDAO;
import com.fot.backcontask.exception.NotFoundException;
import com.fot.backcontask.model.Contract;
import com.fot.backcontask.service.AbstractService;

@Service
public class ContractServiceImpl extends AbstractService<Contract, ContractDAO> implements ContractService {

	@Override
	public Contract getAndCheck(Long id) throws NotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isEqual(Contract u1, Contract u2) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void setValues(Contract to, Contract from) {
		// TODO Auto-generated method stub
		
	}

}
