package com.fot.backcontask.service.contracttype;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import com.fot.backcontask.dao.ContractTypeDAO;
import com.fot.backcontask.exception.NotFoundException;
import com.fot.backcontask.model.ContractType;
import com.fot.backcontask.service.AbstractService;

@Service
public class ContractTypeServiceImpl extends AbstractService<ContractType, ContractTypeDAO> implements ContractTypeService {

	@Override
	public ContractType getAndCheck(Long id) throws NotFoundException {
		return findById(id).orElseThrow(() -> new NotFoundException("El tipo de contrato no existe"));
	}

	@Override
	public boolean isEqual(ContractType ct1, ContractType ct2) {
		return StringUtils.equals(ct1.getName(), ct2.getName());
	}

	@Override
	public void setValues(ContractType to, ContractType from) {
		to.setName(from.getName());
	}
}
