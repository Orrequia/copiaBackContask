package com.fot.backcontask.dto.user;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=false)
public class UserPostDTO extends UserDTO {

	private static final long serialVersionUID = 1578658765L;
	
	private String username;
	private String password;
	private Long idRole;
}
