package com.fot.backcontask.component.mapper.key;

import org.springframework.stereotype.Component;

import com.fot.backcontask.component.mapper.AbstractMapper;
import com.fot.backcontask.dto.key.KeyTypeDTO;
import com.fot.backcontask.model.KeyType;

@Component
public class KeyTypeMapperImpl extends AbstractMapper<KeyType, KeyTypeDTO> implements KeyTypeMapper {

	@Override
	public Class<? extends KeyTypeDTO> dtoClazz() {
		return KeyTypeDTO.class;
	}

	@Override
	public Class<? extends KeyType> modelClazz() {
		return KeyType.class;
	}
}
