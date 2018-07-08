package com.fot.backcontask.dto.company;

import java.io.Serializable;
import java.util.List;

import lombok.Data;

@Data
public class CompanyDTO implements Serializable {
	
	private static final long serialVersionUID = -698748354L;
	
	Long idCompany;
	String nif;
	String name;
	String note;
	Long idOwner;
	Long idCompanyType;
	List<Long> stores;
	List<Long> contracts;
}
