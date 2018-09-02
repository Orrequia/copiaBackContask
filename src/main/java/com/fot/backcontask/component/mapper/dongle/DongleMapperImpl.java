package com.fot.backcontask.component.mapper.dongle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fot.backcontask.component.mapper.AbstractMapper;
import com.fot.backcontask.dto.dongle.DongleDTO;
import com.fot.backcontask.exception.NotFoundException;
import com.fot.backcontask.model.Dongle;
import com.fot.backcontask.service.dongletype.DongleTypeService;

@Component
public class DongleMapperImpl extends AbstractMapper<Dongle, DongleDTO> implements DongleMapper {

	@Autowired
	DongleTypeService keyTypeService;
	
	@Override
	public Class<? extends DongleDTO> dtoClazz() {
		return DongleDTO.class;
	}

	@Override
	public Class<? extends Dongle> modelClazz() {
		return Dongle.class;
	}

	@Override
	public Dongle dtoToModel(DongleDTO dto) throws NotFoundException {
		return map(dto);
	}
	
	private Dongle map(DongleDTO dto) throws NotFoundException {
		Dongle key = dozer.map(dto, modelClazz());
		if(dto.getIdKeyType() != null) key.setKeyType(keyTypeService.getAndCheck(dto.getIdKeyType()));
		return key;
	}

	@Override
	public DongleDTO modelToDto(Dongle model) {
		return map(model);
	}
	
	private DongleDTO map(Dongle model) {
		DongleDTO keyDTO = dozer.map(model, dtoClazz());
		keyDTO.setIdKeyType(model.getKeyType().getIdKeyType());
		return keyDTO;
	}
}
