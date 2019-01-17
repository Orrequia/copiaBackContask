package com.fot.backcontask.model;

import javax.persistence.*;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Population {

	private static final String FIELD_IDPROVINCE = "idProvince";

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idPopulation;
	
	@Column(nullable=false)
	private String name;
	
	@Column
	private String postalCode;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name=FIELD_IDPROVINCE, nullable=false)
	private Province province;
}
