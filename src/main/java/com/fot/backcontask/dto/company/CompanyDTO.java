package com.fot.backcontask.dto.company;

import java.io.Serializable;
import java.util.List;

import lombok.Data;

@Data
public class CompanyDTO implements Serializable {
	
	private static final long serialVersionUID = -698748354L;
	
	private Long idCompany;
	private String nif;
	private String name;
	private String note;
	private Long idOwner;
	private Long idCompanyType;
	private List<Long> stores;
	private List<Long> contracts;
}
