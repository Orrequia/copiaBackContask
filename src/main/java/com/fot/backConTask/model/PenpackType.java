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
public class PenpackType {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idPenpackType;
	
	@Column(nullable=false, unique=true)
	private String name;
}