package com.fot.backcontask.dto.contract;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import lombok.Data;

@Data
public class ContractDTO implements Serializable {

	private static final long serialVersionUID = 19876987456L;

	private Long idContract;
	private Date startDate;
	private Date finishDate;
	private Boolean paid;
	private List<Long> contractlines;
}
