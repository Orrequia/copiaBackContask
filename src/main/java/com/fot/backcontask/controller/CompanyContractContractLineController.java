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

import com.fot.backcontask.component.mapper.contract.ContractLineMapper;
import com.fot.backcontask.dto.contract.ContractLineDTO;
import com.fot.backcontask.exception.InvalidRequestException;
import com.fot.backcontask.exception.NotFoundException;
import com.fot.backcontask.model.ContractLine;
import com.fot.backcontask.service.contractline.ContractLineService;

@RestController
@RequestMapping(value="/company/{idCompany}/contract/{idContract}/contractline")
public class CompanyContractContractLineController {

	@Autowired
	ContractLineService contractLineService;
	
	@Autowired
	ContractLineMapper contractLineMapper;
	
	@GetMapping
	public List<ContractLineDTO> findAll(@RequestParam(defaultValue = "0", required= false ) Integer page, 
							 @RequestParam(defaultValue = "10", required= false ) Integer size,
							 @PathVariable("idCompany") Long idCompany,
							 @PathVariable("idContract") Long idContract) throws NotFoundException {
		final List<ContractLine> contractsLines = contractLineService.findContractLineByCompanyAndContract(idCompany, idContract, PageRequest.of(page, size));
		return contractLineMapper.modelToDto(contractsLines);
	}
	
	@GetMapping("/{idContractLine}")
	public ContractLineDTO findById(@PathVariable("idCompany") Long idCompany,
			 @PathVariable("idContract") Long idContract,
			 @PathVariable("idContractLine") Long idContractLine) throws NotFoundException {
		final ContractLine contractLine = contractLineService.findOneContractLineByCompanyAndContract(idCompany, idContract, idContractLine);
		return contractLineMapper.modelToDto(contractLine);
	}
	
	@PostMapping
	public ContractLineDTO create(@RequestBody ContractLineDTO dto,
			@PathVariable("idCompany") Long idCompany,
			@PathVariable("idContract") Long idContract) throws InvalidRequestException, NotFoundException {
		if(dto.getIdContractLine() != null) 
			throw new InvalidRequestException("El idContractLine no se puede recibir en el body");
		ContractLine createContractLine = contractLineService.addToContract(idContract, contractLineMapper.dtoToModel(dto));
		return contractLineMapper.modelToDto(createContractLine);
	}
	
	@PutMapping("/{idContractLine}")
	public void update(@PathVariable("idCompany") Long idCompany,
			@PathVariable("idContract") Long idContract,
			@PathVariable("idContractLine") Long idContractLine,
		    @RequestBody ContractLineDTO dto) throws InvalidRequestException, NotFoundException {
		if(dto.getIdContractLine() != null) 
			throw new InvalidRequestException("El idContractLine no se puede recibir en el body");
		contractLineService.updateToContract(idCompany, idContract, idContractLine, contractLineMapper.dtoToModel(dto));
	}
	
	@DeleteMapping("/{idContractLine}")
	public void delete(@PathVariable("idCompany") Long idCompany,
			@PathVariable("idContract") Long idContract, 
			@PathVariable("idContractLine") Long idContractLine,
			@RequestBody ContractLineDTO dto) throws NotFoundException, InvalidRequestException {
		contractLineService.deleteToContract(idCompany, idContract, idContractLine, contractLineMapper.dtoToModel(dto));
	}
}
