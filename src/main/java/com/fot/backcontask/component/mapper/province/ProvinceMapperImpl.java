package com.fot.backcontask.component.mapper.province;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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

	@Autowired
	PopulationService populationService;
	
	@Override
	public Class<? extends ProvinceDTO> dtoClazz() {
		return ProvinceDTO.class;
	}

	@Override
	public Class<? extends Province> modelClazz() {
		return Province.class;
	}

	@Override
	public Province dtoToModel(ProvinceDTO dto) throws NotFoundException {
		return map(dto, longToPopulation(dto.getPopulations()));
	}
	
	private List<Population> longToPopulation(List<Long> populations) throws NotFoundException {
		if(populations != null) {
			List<Population> population = populations.stream().map(populationService::findById)
					.filter(Optional::isPresent)
					.map(Optional::get)
					.collect(Collectors.toList());
			if(population.size() != populations.size()) throw new NotFoundException("Algunas o todas las poblaciones no existen");
			return population;
		}
		return new ArrayList<>();
	}
	
	private Province map(ProvinceDTO dto, List<Population> population) {
		Province province = dozer.map(dto, modelClazz());
		province.setPopulation(population);
		return province;
	}

	@Override
	public ProvinceDTO modelToDto(Province model) {
		return map(model, populationToLong(model.getPopulation()));
	}
	
	private List<Long> populationToLong(List<Population> population) {
		return population.stream().map(Population::getIdPopulation).collect(Collectors.toList());
	}
	
	private ProvinceDTO map(Province model, List<Long> populations) {
		ProvinceDTO provinceDTO = dozer.map(model, dtoClazz());
		provinceDTO.setPopulations(populations);
		return provinceDTO;
	}
}
