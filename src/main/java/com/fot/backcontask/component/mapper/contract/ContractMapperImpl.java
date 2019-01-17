package com.fot.backcontask.component.mapper.contract;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fot.backcontask.component.mapper.AbstractMapper;
import com.fot.backcontask.dto.contract.ContractDTO;
import com.fot.backcontask.exception.NotFoundException;
import com.fot.backcontask.model.Contract;
import com.fot.backcontask.model.ContractLine;
import com.fot.backcontask.service.contractline.ContractLineService;

@Component
@AllArgsConstructor(onConstructor_={@Autowired})
public class ContractMapperImpl extends AbstractMapper<Contract, ContractDTO> implements ContractMapper {

	final private ContractLineService contractLineService;
	
	@Override
	public Class<? extends ContractDTO> dtoClazz() {
		return ContractDTO.class;
	}

	@Override
	public Class<? extends Contract> modelClazz() {
		return Contract.class;
	}

	@Override
	public Contract dtoToModel(ContractDTO dto) throws NotFoundException {
		return map(dto, longToContractLine(dto.getContractlines()));
	}
	
	private List<ContractLine> longToContractLine(List<Long> contractLines) throws NotFoundException {
		if(contractLines != null) {
			List<ContractLine> contractLine = contractLines.stream().map(contractLineService::findById)
					.filter(Optional::isPresent)
					.map(Optional::get)
					.collect(Collectors.toList());
		if(contractLines.size() != contractLine.size()) throw new NotFoundException("Algunas o todas las líneas de contrato no existen");
		return contractLine;
		}
		return new ArrayList<>();
	}
	
	private Contract map(ContractDTO dto, List<ContractLine> contractLine) {
		Contract contract = dozer.map(dto, modelClazz());
		contract.setContractLine(contractLine);
		return contract;
	}

	@Override
	public ContractDTO modelToDto(Contract model) {
		return map(model, contractLineToLong(model.getContractLine()));
	}
	
	private List<Long> contractLineToLong(List<ContractLine> contractLine) {
		return contractLine.stream().map(ContractLine::getIdContractLine).collect(Collectors.toList());
	}
	
	private ContractDTO map(Contract model, List<Long> contractLines) {
		ContractDTO contractDTO = dozer.map(model, dtoClazz());
		contractDTO.setContractlines(contractLines);
		return contractDTO;
	}
}
