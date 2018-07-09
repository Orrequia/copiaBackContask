package com.fot.backcontask.controller;

import com.fasterxml.classmate.util.ResolvedTypeCache.Key;
import com.fot.backcontask.dto.key.KeyDTO;

public class KeyController extends AbstractController<Key, KeyDTO> {

	@Override
	public Class<KeyDTO> clazz() {
		return KeyDTO.class;
	}
}
