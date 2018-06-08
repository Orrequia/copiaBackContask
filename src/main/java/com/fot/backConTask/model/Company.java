package com.fot.backConTask.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Company {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idCompany;
	
	@Column(unique=true, nullable=true)
	private String nif;
	
	@Column(nullable=false)
	private String name;
	
	@Column(nullable=true)
	private String note;
}
