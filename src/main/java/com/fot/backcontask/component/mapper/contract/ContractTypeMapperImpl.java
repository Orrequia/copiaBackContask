package com.fot.backcontask.component.mapper.contract;

import com.fot.backcontask.component.mapper.AbstractMapper;
import com.fot.backcontask.dto.contract.ContractTypeDTO;
import com.fot.backcontask.model.ContractType;

public class ContractTypeMapperImpl extends AbstractMapper<ContractType, ContractTypeDTO> implements ContractTypeMapper {

	@Override
	public Class<? extends ContractTypeDTO> dtoClazz() {
		return ContractTypeDTO.class;
	}

	@Override
	public Class<? extends ContractType> modelClazz() {
		return ContractType.class;
	}

}
