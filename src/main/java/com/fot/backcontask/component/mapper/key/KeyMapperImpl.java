package com.fot.backcontask.component.mapper.key;

import com.fasterxml.classmate.util.ResolvedTypeCache.Key;
import com.fot.backcontask.component.mapper.AbstractMapper;
import com.fot.backcontask.dto.key.KeyDTO;

public class KeyMapperImpl extends AbstractMapper<Key, KeyDTO> implements KeyMapper {

	@Override
	public Class<? extends KeyDTO> dtoClazz() {
		return KeyDTO.class;
	}

	@Override
	public Class<? extends Key> modelClazz() {
		return Key.class;
	}

}
