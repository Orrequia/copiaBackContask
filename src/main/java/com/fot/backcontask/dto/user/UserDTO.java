package com.fot.backcontask.dto.user;

import java.io.Serializable;

import lombok.Data;

@Data
public class UserDTO implements Serializable {

	private static final long serialVersionUID = -16895765764L;
	
	private Long idUser;
	private String name;
	private String email;
	private String phone;
	private Long idRole;
}
