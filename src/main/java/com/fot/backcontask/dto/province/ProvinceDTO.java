package com.fot.backcontask.dto.province;

import java.io.Serializable;
import java.util.List;

import lombok.Data;

@Data
public class ProvinceDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private Long idProvince;
	private String name;
}
