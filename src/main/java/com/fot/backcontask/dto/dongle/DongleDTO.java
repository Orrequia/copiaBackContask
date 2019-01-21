package com.fot.backcontask.dto.dongle;

import java.io.Serializable;

import lombok.Data;

@Data
public class DongleDTO implements Serializable {

	private static final long serialVersionUID = 19876987698L;
	
	private Long idDongle;
	private String license;
	private Long idDongleType;
}
