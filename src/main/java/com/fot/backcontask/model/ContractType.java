package com.fot.backcontask.model;

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
public class ContractType {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idContractType;
	
	@Column(nullable=false, unique=true)
	private String name;
}