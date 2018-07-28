package com.fot.backcontask.service.contractline;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.fot.backcontask.dao.ContractLineDAO;
import com.fot.backcontask.exception.InvalidRequestException;
import com.fot.backcontask.exception.NotFoundException;
import com.fot.backcontask.model.Company;
import com.fot.backcontask.model.Contract;
import com.fot.backcontask.model.ContractLine;
import com.fot.backcontask.service.AbstractService;
import com.fot.backcontask.service.company.CompanyService;
import com.fot.backcontask.service.contract.ContractService;

@Service
public class ContractLineServiceImpl extends AbstractService<ContractLine, ContractLineDAO> implements ContractLineService {
	
	@Autowired
	CompanyService companyService;
	
	@Autowired
	ContractService contractService;
	
	@Override
	public ContractLine getAndCheck(Long id) throws NotFoundException {
		return findById(id).orElseThrow(() -> new NotFoundException("La línea de contrato no existe"));
	}

	@Override
	public boolean isEqual(ContractLine cl1, ContractLine cl2) {
		return cl1.getPrice().compareTo(cl2.getPrice()) == 0 &&
				cl1.getContractType().equals(cl2.getContractType()) &&
				cl1.getKey().equals(cl2.getKey());
	}

	@Override
	public void setValues(ContractLine to, ContractLine from) {
		to.setPrice(from.getPrice());
		to.setContractType(from.getContractType());
		to.setKey(from.getKey());
	}
	
	@Override
	public ContractLine findOneContractLineByCompanyAndContract(Long idCompany, Long idContract, Long idContractLine) throws NotFoundException {
		return getAndCheckBelongCompanyAndContract(companyService.getAndCheck(idCompany), idContract, idContractLine);
	}
	
	private ContractLine getAndCheckBelongCompanyAndContract(Company company, Long idContract, Long idContractLine) throws NotFoundException {
		return company
				.getContract().stream().filter(q -> q.getIdContract() == idContract)
				.findFirst()
				.orElseThrow(() -> new NotFoundException("Este contrato no existe para esta empresa"))
				.getContractLine().stream().filter(c -> c.getIdContractLine() == idContractLine)
				.findFirst().orElseThrow(() -> new NotFoundException("Esta línea de contrato no existe para este contrato"));
	}

	@Override
	public List<ContractLine> findContractLineByCompanyAndContract(Long idCompany, Long idContract, Pageable p) throws NotFoundException {
		companyService.getAndCheck(idCompany);
		contractService.getAndCheck(idContract);
		return dao.findByCompanyAndContract(idCompany, idContract, PageRequest.of(p.getPageNumber(), p.getPageSize()));
	}

	@Override
	public ContractLine addToContract(Long idContract, ContractLine contractLine) throws NotFoundException {
		final ContractLine createContractLine = create(contractLine);
		contractService.addContractLine(contractService.getAndCheck(idContract), createContractLine);
		return createContractLine;
	}

	@Override
	public void updateToContract(Long idCompany, Long idContract, Long idContractLine, ContractLine newContractLine) throws NotFoundException {
		final Company company = companyService.getAndCheck(idCompany);
		final ContractLine contractLine = this.getAndCheckBelongCompanyAndContract(company, idContract, idContractLine);
		this.setValues(contractLine, newContractLine);
		this.update(contractLine);
	}

	@Override
	public void deleteToContract(Long idCompany, Long idContract, Long idContractLine, ContractLine bodyContractLine) throws NotFoundException, InvalidRequestException {
		final Company company = companyService.getAndCheck(idCompany);
		final ContractLine contractLine = this.getAndCheckBelongCompanyAndContract(company, idContract, idContractLine);
		if(!this.isEqual(bodyContractLine, contractLine))
			throw new InvalidRequestException("El contrato recibido no coincide con el almacenado");
		contractService.removeContractLine(company, contractLine);
	}
}
