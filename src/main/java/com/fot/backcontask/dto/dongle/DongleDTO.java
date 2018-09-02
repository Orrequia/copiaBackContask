package com.fot.backcontask.dto.key;

import java.io.Serializable;

import lombok.Data;

@Data
public class KeyDTO implements Serializable {

	private static final long serialVersionUID = 19876987698L;
	
	private Long idKey;
	private String license;
	private Long idKeyType;
}
