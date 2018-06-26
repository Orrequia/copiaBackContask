package com.fot.backcontask.dto.user;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=false)
public class UserPostDTO extends UserDTO {

	private String username;
	private String password;
	private Integer idRole;
}
