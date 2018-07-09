package com.fot.backcontask.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fot.backcontask.dto.contract.ContractTypeDTO;
import com.fot.backcontask.model.ContractType;

@RestController
@RequestMapping("/contractType")
public class ContractTypeController extends AbstractController<ContractType, ContractTypeDTO> {
	
}
