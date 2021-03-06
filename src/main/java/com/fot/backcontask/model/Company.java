package com.fot.backcontask.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
public class Company {

	public static final String FIELD_IDCOMPANY = "idCompany";
	public static final String FIELD_IDEMPLOYEE = "idEmployee";
	public static final String FIELD_IDCOMPANYTYPE = "idCompanyType";
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idCompany;
	
	@Column(unique=true)
	private String nif;
	
	@Column(nullable=false)
	private String name;
	
	@Column
	private String note;
	
	@OneToMany(fetch=FetchType.LAZY, cascade=CascadeType.REMOVE)
	@JoinColumn(name=FIELD_IDCOMPANY, referencedColumnName=FIELD_IDCOMPANY)
	private List<Store> store;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name=FIELD_IDEMPLOYEE, nullable=false)
	private Employee owner;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name=FIELD_IDCOMPANYTYPE, nullable=false)
	private CompanyType companyType;
	
	@OneToMany(fetch=FetchType.LAZY, cascade=CascadeType.REMOVE)
	@JoinColumn(name=FIELD_IDCOMPANY, referencedColumnName=FIELD_IDCOMPANY)
	private List<Contract> contract;
}
