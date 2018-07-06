package com.fot.backcontask.service.contractline;

import org.springframework.stereotype.Service;

import com.fot.backcontask.dao.ContractLineDAO;
import com.fot.backcontask.exception.NotFoundException;
import com.fot.backcontask.model.ContractLine;
import com.fot.backcontask.service.AbstractService;

@Service
public class ContractLineServiceImpl extends AbstractService<ContractLine, ContractLineDAO> implements ContractLineService {

	@Override
	public ContractLine getAndCheck(Long id) throws NotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isEqual(ContractLine u1, ContractLine u2) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void setValues(ContractLine to, ContractLine from) {
		// TODO Auto-generated method stub
		
	}

}
