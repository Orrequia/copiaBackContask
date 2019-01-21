package com.fot.backcontask.dto.contract;

import java.io.Serializable;

import lombok.Data;

@Data
public class ContractLineDTO implements Serializable {
	
	private static final long serialVersionUID = 184723465456L;
	
	private Long idContractLine;
	private Float price;
	private Long idContractType;
	private Long idDongle;
}
