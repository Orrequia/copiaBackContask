package com.fot.backcontask.component.mapper.contract;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fot.backcontask.component.mapper.AbstractMapper;
import com.fot.backcontask.dto.contract.ContractLineDTO;
import com.fot.backcontask.exception.NotFoundException;
import com.fot.backcontask.model.ContractLine;
import com.fot.backcontask.service.contracttype.ContractTypeService;
import com.fot.backcontask.service.dongle.DongleService;

@Component
public class ContractLineMapperImpl extends AbstractMapper<ContractLine, ContractLineDTO> implements ContractLineMapper {

	@Autowired
	ContractTypeService contractTypeService;
	
	@Autowired
	DongleService keyService;
	
	@Override
	public Class<? extends ContractLineDTO> dtoClazz() {
		return ContractLineDTO.class;
	}

	@Override
	public Class<? extends ContractLine> modelClazz() {
		return ContractLine.class;
	}

	@Override
	public ContractLine dtoToModel(ContractLineDTO dto) throws NotFoundException {
		return map(dto);
	}
	
	private ContractLine map(ContractLineDTO dto) throws NotFoundException {
		ContractLine contractLine = dozer.map(dto, modelClazz());
		if(dto.getIdContractType() != null) contractLine.setContractType(contractTypeService.getAndCheck(dto.getIdContractType()));
		if(dto.getIdKey() != null) contractLine.setKey(keyService.getAndCheck(dto.getIdKey()));
		return contractLine;
	}

	@Override
	public ContractLineDTO modelToDto(ContractLine model) {
		return map(model);
	}
	
	private ContractLineDTO map(ContractLine model) {
		ContractLineDTO contractLineDTO = dozer.map(model, dtoClazz());
		contractLineDTO.setIdContractType(model.getContractType().getIdContractType());
		contractLineDTO.setIdKey(model.getKey().getIdKey());
		return contractLineDTO;
	}
}
