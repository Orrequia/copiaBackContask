package com.fot.backcontask.dto.dongle;

import java.io.Serializable;

import lombok.Data;

@Data
public class DongleTypeDTO implements Serializable {

	private static final long serialVersionUID = 1098757354L;
	
	private Long idDongleType;
	private String name;
}
