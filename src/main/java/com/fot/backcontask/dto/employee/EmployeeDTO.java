package com.fot.backcontask.dto.employee;

import java.io.Serializable;

import lombok.Data;

@Data
public class EmployeeDTO implements Serializable {

	private static final long serialVersionUID = 1986534526L;

	private Long idEmployee;
	private String name;
	private String phone;
	private String email;
}
