package com.fot.backcontask.component.mapper.store;

import org.springframework.stereotype.Component;

import com.fot.backcontask.component.mapper.AbstractMapper;
import com.fot.backcontask.dto.store.StoreDTO;
import com.fot.backcontask.model.Store;

@Component
public class StoreMapperImpl extends AbstractMapper<Store, StoreDTO> implements StoreMapper {

	@Override
	public Class<? extends StoreDTO> dtoClazz() {
		return StoreDTO.class;
	}

	@Override
	public Class<? extends Store> modelClazz() {
		return Store.class;
	}

}
