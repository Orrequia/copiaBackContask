package com.fot.backcontask.component.mapper.dongle;

import org.springframework.stereotype.Component;

import com.fot.backcontask.component.mapper.AbstractMapper;
import com.fot.backcontask.dto.dongle.DongleTypeDTO;
import com.fot.backcontask.model.DongleType;

@Component
public class DongleTypeMapperImpl extends AbstractMapper<DongleType, DongleTypeDTO> implements DongleTypeMapper {

	@Override
	public Class<? extends DongleTypeDTO> dtoClazz() {
		return DongleTypeDTO.class;
	}

	@Override
	public Class<? extends DongleType> modelClazz() {
		return DongleType.class;
	}
}
