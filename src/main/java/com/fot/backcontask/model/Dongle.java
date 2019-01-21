package com.fot.backcontask.model;

import javax.persistence.*;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class Dongle {

	private static final String FIELD_IDDONGLE = "idDongle";
	private static final String FIELD_IDDONGLETYPE = "idDongleType";
	private static final String FIELD_IDDONGLEMODULE = "idDongleModule";

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idDongle;
	
	@Column(nullable=false)
	private String license;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name=FIELD_IDDONGLETYPE, nullable=false)
	private DongleType dongleType;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name=FIELD_IDDONGLEMODULE, nullable=false)
	private DongleModule dongleModule;

	@OneToMany(fetch=FetchType.LAZY, cascade=CascadeType.REMOVE)
	@JoinColumn(name=FIELD_IDDONGLE, referencedColumnName=FIELD_IDDONGLE)
	private List<ActiveDongleComplement> activeDongleComplement;

	@OneToMany(fetch=FetchType.LAZY, cascade=CascadeType.REMOVE)
	@JoinColumn(name=FIELD_IDDONGLE, referencedColumnName=FIELD_IDDONGLE)
	private List<ActiveCatalog> activeCatalog;
}
