package com.fot.backcontask.dto.key;

import java.io.Serializable;

import lombok.Data;

@Data
public class KeyTypeDTO implements Serializable {

	private static final long serialVersionUID = 1098757354L;
	
	private Long idKeyType;
	private String name;
}
