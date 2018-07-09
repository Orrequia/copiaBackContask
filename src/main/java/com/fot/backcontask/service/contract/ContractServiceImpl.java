package com.fot.backcontask.service.contract;

import org.apache.commons.lang3.BooleanUtils;
import org.apache.commons.lang3.time.DateUtils;
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
		return DateUtils.isSameInstant(c1.getStartDate(), c2.getStartDate()) &&
				DateUtils.isSameInstant(c1.getFinishDate(), c2.getFinishDate()) &&
				BooleanUtils.compare(c1.getPaid(), c2.getPaid()) == 0 &&
				c1.getContractLine().equals(c2.getContractLine());
	}

	@Override
	public void setValues(Contract to, Contract from) {
		to.setStartDate(from.getStartDate());
		to.setFinishDate(from.getFinishDate());
		to.setPaid(from.getPaid());
		to.setContractLine(from.getContractLine());
	}

}
