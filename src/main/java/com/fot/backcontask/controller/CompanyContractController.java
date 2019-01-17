package com.fot.backcontask.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fot.backcontask.component.mapper.contract.ContractMapper;
import com.fot.backcontask.dto.contract.ContractDTO;
import com.fot.backcontask.exception.InvalidRequestException;
import com.fot.backcontask.exception.NotFoundException;
import com.fot.backcontask.model.Contract;
import com.fot.backcontask.service.contract.ContractService;

@RestController
@RequestMapping(value="/company/{idCompany}/contract")
class CompanyContractController {

	private final ContractService contractService;
	private final ContractMapper contractMapper;

	@Autowired
	public CompanyContractController(ContractService contractService, ContractMapper contractMapper) {
		this.contractService = contractService;
		this.contractMapper = contractMapper;
	}

	@GetMapping
	public List<ContractDTO> findAll(@RequestParam(defaultValue = "0", required= false ) Integer page, 
							 @RequestParam(defaultValue = "10", required= false ) Integer size,
							 @PathVariable("idCompany") Long idCompany) throws NotFoundException {
		final List<Contract> contracts = contractService.findContractByCompany(idCompany, PageRequest.of(page, size));
		return contractMapper.modelToDto(contracts);
	}
	
	@GetMapping("/{idContract}")
	public ContractDTO findById(@PathVariable("idCompany") Long idCompany,
			 @PathVariable("idContract") Long idContract) throws NotFoundException {
		final Contract contract = contractService.findOneContractByCompany(idCompany, idContract);
		return contractMapper.modelToDto(contract);
	}
	
	@PostMapping
	public ContractDTO create(@RequestBody ContractDTO dto,
			@PathVariable("idCompany") Long idCompany) throws InvalidRequestException, NotFoundException {
		if(dto.getIdContract() != null) 
			throw new InvalidRequestException("El idContract no se puede recibir en el body");
		Contract createContract = contractService.addToCompany(idCompany, contractMapper.dtoToModel(dto));
		return contractMapper.modelToDto(createContract);
	}
	
	@PutMapping("/{idContract}")
	public void update(@PathVariable("idCompany") Long idCompany,
			@PathVariable("idContract") Long idContract, 
			@RequestParam(defaultValue = "false", required = false) Boolean autoQuestions,
			@RequestParam(defaultValue = "10", required = false) Integer nQuestions,
		    @RequestBody ContractDTO dto) throws InvalidRequestException, NotFoundException {
		if(dto.getIdContract() != null) 
			throw new InvalidRequestException("El idContract no se puede recibir en el body");
		contractService.updateToCompany(idCompany, idContract, contractMapper.dtoToModel(dto));
	}
	
	@DeleteMapping("/{idContract}")
	public void delete(@PathVariable("idCompany") Long idCompany,
			@PathVariable("idContract") Long idContract, 
			@RequestBody ContractDTO dto) throws NotFoundException, InvalidRequestException {
		contractService.deleteToCompany(idCompany, idContract, contractMapper.dtoToModel(dto));
	}
}
