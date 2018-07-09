package com.fot.backcontask.component.mapper.company;

import org.springframework.stereotype.Component;

import com.fot.backcontask.component.mapper.AbstractMapper;
import com.fot.backcontask.dto.company.CompanyTypeDTO;
import com.fot.backcontask.model.CompanyType;

@Component
public class CompanyTypeMapperImpl extends AbstractMapper<CompanyType, CompanyTypeDTO> implements CompanyTypeMapper {

	@Override
	public Class<? extends CompanyTypeDTO> dtoClazz() {
		return CompanyTypeDTO.class;
	}

	@Override
	public Class<? extends CompanyType> modelClazz() {
		return CompanyType.class;
	}
}
