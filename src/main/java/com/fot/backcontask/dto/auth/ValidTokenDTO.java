package com.fot.backcontask.dto.auth;

import lombok.Data;

@Data
public class ValidTokenDTO {

	private String subject; 
	
	public ValidTokenDTO(String sub) {
		this.subject = sub;
	}
}
