package com.fot.backcontask.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fot.backcontask.dto.contract.ContractLineDTO;
import com.fot.backcontask.model.ContractLine;

@RestController
@RequestMapping("/contractLine")
public class ContractLineController extends AbstractController<ContractLine, ContractLineDTO>{

}
