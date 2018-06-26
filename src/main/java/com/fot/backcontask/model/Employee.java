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
public class Employee {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idEmployee;
	
	@Column(nullable=false)
	private String name;
	
	@Column
	private String phone;
	
	@Column
	private String email;
}
