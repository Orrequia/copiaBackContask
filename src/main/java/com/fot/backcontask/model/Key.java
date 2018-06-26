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
public class Key {

	private static final String FIELD_IDKEYTYPE = "idKeyType";
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idKey;
	
	@Column(nullable=false)
	private String license;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name=FIELD_IDKEYTYPE)
	private KeyType keyType;
}
