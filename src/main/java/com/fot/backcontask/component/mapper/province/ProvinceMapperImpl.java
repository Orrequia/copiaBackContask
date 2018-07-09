package com.fot.backcontask.component.mapper.province;

import org.springframework.stereotype.Component;

import com.fot.backcontask.component.mapper.AbstractMapper;
import com.fot.backcontask.dto.province.ProvinceDTO;
import com.fot.backcontask.model.Province;

@Component
public class ProvinceMapperImpl extends AbstractMapper<Province, ProvinceDTO> {

	@Override
	public Class<? extends ProvinceDTO> dtoClazz() {
		return ProvinceDTO.class;
	}

	@Override
	public Class<? extends Province> modelClazz() {
		return Province.class;
	}
}
