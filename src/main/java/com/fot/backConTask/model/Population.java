package com.fot.backConTask.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Population {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idPopulation;
	
	@Column(nullable=false)
	private String name;
	
	@Column
	private String postalCode;
}
