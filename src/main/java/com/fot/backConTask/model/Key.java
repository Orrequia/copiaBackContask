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
public class Key {

	private static final String FIELD_IDPENPACKTYPE = "idPenpackType";
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idPenpack;
	
	@Column(nullable=false)
	private String license;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name=FIELD_IDPENPACKTYPE)
	private KeyType penpackType;
}
