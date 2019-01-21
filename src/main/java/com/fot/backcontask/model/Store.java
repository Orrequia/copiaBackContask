package com.fot.backcontask.model;

import java.util.List;

import javax.persistence.*;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Store {

	private static final String FIELD_IDSTORE = "idStore";
	private static final String FIELD_IDEMPLOYEE = "IdEmployee";
	private static final String FIELD_IDPOPULATION = "IdPopulation";
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idStore;
	
	@Column()
	private String name;
	
	@Column
	private String address;

	@Column
	private String phone;

	@Column
	private String email;

	@ManyToMany(fetch=FetchType.LAZY)
	@JoinTable(name="store_employee",
			joinColumns=@JoinColumn(name=FIELD_IDSTORE, referencedColumnName=FIELD_IDSTORE),
			inverseJoinColumns=@JoinColumn(name=FIELD_IDEMPLOYEE, referencedColumnName=FIELD_IDEMPLOYEE))
	private List<Employee> employee;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name=FIELD_IDEMPLOYEE)
	private Employee responsible;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name=FIELD_IDPOPULATION)
	private Population population;

	@OneToMany(fetch=FetchType.LAZY, cascade=CascadeType.REMOVE)
	@JoinColumn(name=FIELD_IDSTORE, referencedColumnName=FIELD_IDSTORE)
	private List<Dongle> dongle;
}
