package com.fot.backcontask.component.mapper.population;

import com.fot.backcontask.exception.NotFoundException;
import com.fot.backcontask.service.province.ProvinceService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fot.backcontask.component.mapper.AbstractMapper;
import com.fot.backcontask.dto.population.PopulationDTO;
import com.fot.backcontask.model.Population;

@Component
@AllArgsConstructor(onConstructor_={@Autowired})
public class PopulationMapperImpl extends AbstractMapper<Population, PopulationDTO> implements PopulationMapper {

	final private ProvinceService provinceService;

	@Override
	public Class<? extends PopulationDTO> dtoClazz() {
		return PopulationDTO.class;
	}

	@Override
	public Class<? extends Population> modelClazz() {
		return Population.class;
	}

	@Override
	public Population dtoToModel(PopulationDTO dto) throws NotFoundException {
		return map(dto);
	}

	private Population map(PopulationDTO dto) throws NotFoundException {
		Population population = dozer.map(dto, modelClazz());
		if(dto.getIdProvince() != null) population.setProvince(provinceService.getAndCheck(dto.getIdProvince()));
		return population;
	}

	@Override
	public PopulationDTO modelToDto(Population model) {
		return map(model);
	}

	private PopulationDTO map(Population model) {
		PopulationDTO populationDTO = dozer.map(model, dtoClazz());
		populationDTO.setIdProvince(model.getProvince().getIdProvince());
		return populationDTO;
	}
}
