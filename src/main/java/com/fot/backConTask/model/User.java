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
public class User {
	
	private static final String FIELD_IDROLE = "idRole";
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idUser;
	
	@Column
	private String name;
	
	@Column
	private String email;
	
	@Column
	private String phone;
	
	@Column(unique=true, nullable=false)
	private String username;
	
	@Column(nullable=false)
	private String password;
	
	private Boolean enabled;
	private Boolean tokenExpired;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name=FIELD_IDROLE)
	private Role role;
}
