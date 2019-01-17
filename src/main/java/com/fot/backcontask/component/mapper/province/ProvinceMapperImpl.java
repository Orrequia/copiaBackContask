package com.fot.backcontask.component.mapper.province;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fot.backcontask.component.mapper.AbstractMapper;
import com.fot.backcontask.dto.province.ProvinceDTO;
import com.fot.backcontask.exception.NotFoundException;
import com.fot.backcontask.model.Population;
import com.fot.backcontask.model.Province;
import com.fot.backcontask.service.population.PopulationService;

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
