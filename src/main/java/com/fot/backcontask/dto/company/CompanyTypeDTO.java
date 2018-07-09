package com.fot.backcontask.dto.company;

import java.io.Serializable;

import lombok.Data;

@Data
public class CompanyTypeDTO implements Serializable {

	private static final long serialVersionUID = 198769875832L;
	
	private Long idCompanyType;
	private String name;
}
