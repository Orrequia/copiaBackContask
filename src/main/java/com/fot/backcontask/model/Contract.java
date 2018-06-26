package com.fot.backcontask.model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Contract {

	private static final String FIELD_IDCONTRACT = "idContract";
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idContract;
	
	@Temporal(TemporalType.DATE)
	private Date startDate;
	
	@Temporal(TemporalType.DATE)
	private Date finishDate;
	
	@Column
	private Boolean paid;
	
	@OneToMany(fetch=FetchType.LAZY, cascade=CascadeType.REMOVE)
	@JoinColumn(name=FIELD_IDCONTRACT, referencedColumnName=FIELD_IDCONTRACT)
	private List<ContractLine> contractLine;
}
