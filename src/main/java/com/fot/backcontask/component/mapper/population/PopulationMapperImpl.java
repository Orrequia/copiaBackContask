package com.fot.backcontask.component.mapper.population;

import org.springframework.stereotype.Component;

import com.fot.backcontask.component.mapper.AbstractMapper;
import com.fot.backcontask.dto.population.PopulationDTO;
import com.fot.backcontask.model.Population;

@Component
public class PopulationMapperImpl extends AbstractMapper<Population, PopulationDTO> implements PopulationMapper {

	@Override
	public Class<? extends PopulationDTO> dtoClazz() {
		return PopulationDTO.class;
	}

	@Override
	public Class<? extends Population> modelClazz() {
		return Population.class;
	}
}
