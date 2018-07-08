package com.fot.backcontask.service.contract;

import org.apache.commons.codec.binary.StringUtils;
import org.springframework.stereotype.Service;

import com.fot.backcontask.dao.ContractDAO;
import com.fot.backcontask.exception.NotFoundException;
import com.fot.backcontask.model.Contract;
import com.fot.backcontask.service.AbstractService;

@Service
public class ContractServiceImpl extends AbstractService<Contract, ContractDAO> implements ContractService {

	@Override
	public Contract getAndCheck(Long id) throws NotFoundException {
		return findById(id).orElseThrow(() -> new NotFoundException("El contrato no existe"));
	}

	@Override
	public boolean isEqual(Contract c1, Contract c2) {
		return DateUtils..equals(c1.getStartDate(), c2.getStartDate()) &&
				StringUtils.equals(cs1, cs2);
	}

	@Override
	public void setValues(Contract to, Contract from) {
		// TODO Auto-generated method stub
		
	}

}
