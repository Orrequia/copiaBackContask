package com.fot.backcontask.dto.company;

import java.util.List;

import lombok.Data;

@Data
public class CompanyDTO {
	Long idCompany;
	String nif;
	String name;
	String note;
	Long idOwner;
	Long idCompanyType;
	List<Long> stores;
	List<Long> contracts;
}
