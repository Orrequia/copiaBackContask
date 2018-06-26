package com.fot.backcontask.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Province {
	
	private static final String FIELD_IDPROVINCE = "idProvince";
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idProvince;
	
	@Column(nullable=false)
	private String name;
	
	@OneToMany(fetch=FetchType.LAZY)
	@JoinColumn(name=FIELD_IDPROVINCE, referencedColumnName=FIELD_IDPROVINCE)
	private List<Population> population;
}
