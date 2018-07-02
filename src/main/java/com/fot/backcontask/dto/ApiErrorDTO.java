package com.fot.backcontask.dto;

import java.io.Serializable;

import lombok.Data;

@Data
public class ApiErrorDTO implements Serializable {

	private static final long serialVersionUID = 198587684L;

	private Integer code;
	private String msg;
	
	public ApiErrorDTO() {
		super();
	}
	
	public ApiErrorDTO(Integer code, String msg) {
		super();
		this.code = code;
		this.msg = msg;
	}
}
