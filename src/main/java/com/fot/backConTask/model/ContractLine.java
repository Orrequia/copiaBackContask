package com.fot.backConTask.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class ContractLine {

	private static final String FIELD_IDCONTRACTTYPE = "idContractType";
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idContractLine;
	
	@Column
	private Float price;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name=FIELD_IDCONTRACTTYPE)
	private ContractType contractType;
}
