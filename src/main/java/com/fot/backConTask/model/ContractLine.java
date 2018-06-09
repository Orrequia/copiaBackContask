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
public class ContractLine {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idContractLine;
	
	@Column
	private Float price;
}
