package com.fot.backcontask.dto.store;

import java.io.Serializable;
import java.util.List;

import lombok.Data;

@Data
public class StoreDTO implements Serializable {

	private static final long serialVersionUID = 1765476547L;
	
	private Long idStore;
	private String name;
	private String address;
	private String email;
	private List<Long> employees;
	private Long idResponsible;
	private Long idPopulation;
}
