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
		return findById(id).orElseThrow(() -> new NotFoundException("La línea de contrato no existe"));
	}

	@Override
	public boolean isEqual(ContractLine cl1, ContractLine cl2) {
		return cl1.getPrice().compareTo(cl2.getPrice()) == 0 &&
				cl1.getContractType().equals(cl2.getContractType()) &&
				cl1.getKey().equals(cl2.getKey());
	}

	@Override
	public void setValues(ContractLine to, ContractLine from) {
		to.setPrice(from.getPrice());
		to.setContractType(from.getContractType());
		to.setKey(from.getKey());
	}
}
