package com.fot.backcontask.component.mapper.key;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fot.backcontask.component.mapper.AbstractMapper;
import com.fot.backcontask.dto.key.KeyDTO;
import com.fot.backcontask.exception.NotFoundException;
import com.fot.backcontask.model.Key;
import com.fot.backcontask.service.keytype.KeyTypeService;

@Component
public class KeyMapperImpl extends AbstractMapper<Key, KeyDTO> implements KeyMapper {

	@Autowired
	KeyTypeService keyTypeService;
	
	@Override
	public Class<? extends KeyDTO> dtoClazz() {
		return KeyDTO.class;
	}

	@Override
	public Class<? extends Key> modelClazz() {
		return Key.class;
	}

	@Override
	public Key dtoToModel(KeyDTO dto) throws NotFoundException {
		return map(dto);
	}
	
	private Key map(KeyDTO dto) throws NotFoundException {
		Key key = dozer.map(dto, modelClazz());
		if(dto.getIdKeyType() != null) key.setKeyType(keyTypeService.getAndCheck(dto.getIdKeyType()));
		return key;
	}

	@Override
	public KeyDTO modelToDto(Key model) {
		return map(model);
	}
	
	private KeyDTO map(Key model) {
		KeyDTO keyDTO = dozer.map(model, dtoClazz());
		keyDTO.setIdKeyType(model.getKeyType().getIdKeyType());
		return keyDTO;
	}
}
