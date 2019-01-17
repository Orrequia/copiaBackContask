package com.fot.backcontask.dto.population;

import java.io.Serializable;

import lombok.Data;

@Data
public class PopulationDTO implements Serializable {
	
	private static final long serialVersionUID = 187654533477L;

	private Long idPopulation;
	private String name;
	private String postalCode;
	private Long idProvince;
}
