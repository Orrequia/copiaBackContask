package com.fot.backcontask.model;

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
	private static final String FIELD_IDKEY = "idKey";
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idContractLine;
	
	@Column
	private Float price;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name=FIELD_IDCONTRACTTYPE, nullable=false)
	private ContractType contractType;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name=FIELD_IDKEY, nullable=false)
	private Key key;
}
