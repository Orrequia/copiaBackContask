package com.fot.backcontask.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fot.backcontask.dto.contract.ContractDTO;
import com.fot.backcontask.model.Contract;

@RestController
@RequestMapping("/contract")
public class ContractController extends AbstractController<Contract, ContractDTO> {

}
