package com.fot.backcontask.service.contract;

import java.util.List;
import java.util.Optional;

import org.apache.commons.lang3.BooleanUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.fot.backcontask.dao.ContractDAO;
import com.fot.backcontask.exception.InvalidRequestException;
import com.fot.backcontask.exception.NotFoundException;
import com.fot.backcontask.model.Company;
import com.fot.backcontask.model.Contract;
import com.fot.backcontask.model.ContractLine;
import com.fot.backcontask.service.AbstractService;
import com.fot.backcontask.service.company.CompanyService;

@Service
public class ContractServiceImpl extends AbstractService<Contract, ContractDAO> implements ContractService {

	@Autowired
	CompanyService companyService;
	
	@Override
	public Contract getAndCheck(Long id) throws NotFoundException {
		return findById(id).orElseThrow(() -> new NotFoundException("El contrato no existe"));
	}

	@Override
	public boolean isEqual(Contract c1, Contract c2) {
		return DateUtils.isSameInstant(c1.getStartDate(), c2.getStartDate()) &&
				DateUtils.isSameInstant(c1.getFinishDate(), c2.getFinishDate()) &&
				BooleanUtils.compare(c1.getPaid(), c2.getPaid()) == 0 &&
				c1.getContractLine().equals(c2.getContractLine());
	}

	@Override
	public void setValues(Contract to, Contract from) {
		to.setStartDate(from.getStartDate());
		to.setFinishDate(from.getFinishDate());
		to.setPaid(from.getPaid());
		to.setContractLine(from.getContractLine());
	}

	@Override
	public Contract findOneContractByCompany(Long idCompany, Long idContract) throws NotFoundException {
		final Company company = companyService.getAndCheck(idCompany);
		return getAndCheckBelongCompany(company, idContract);
	}
	
	private Contract getAndCheckBelongCompany(Company company, Long idContract) throws NotFoundException {
		final Optional<Contract> contract = company.getContract().stream()
				.filter(q -> q.getIdContract() == idContract)
				.findFirst();
		return contract.orElseThrow(() -> new NotFoundException("Este contrato no existe para esta empresa"));
	}
	
	@Override
	public List<Contract> findContractByCompany(Long idCompany, Pageable p) throws NotFoundException {
		companyService.getAndCheck(idCompany);
		return dao.findByCompany(idCompany, PageRequest.of(p.getPageNumber(), p.getPageSize()));
	}
	
	@Override
	public Contract addToCompany(Long idCompany, Contract contract) throws NotFoundException {
		final Contract createContract = create(contract);
		companyService.addContract(companyService.getAndCheck(idCompany), createContract);
		return createContract;
	}
	
	@Override
	public void updateToCompany(Long idCompany, Long idContract, Contract newContract) throws NotFoundException {
		final Company company = companyService.getAndCheck(idCompany);
		final Contract contract = this.getAndCheckBelongCompany(company, idContract);
		this.setValues(contract, newContract);
		this.update(contract);
	}
	
	@Override
	public void deleteToCompany(Long idCompany, Long idContract, Contract bodyContract) throws NotFoundException, InvalidRequestException {
		final Company company = companyService.getAndCheck(idCompany);
		final Contract contract = this.getAndCheckBelongCompany(company, idContract);
		if(!this.isEqual(bodyContract, contract))
			throw new InvalidRequestException("El contrato recibido no coincide con el almacenado");
		companyService.removeContract(company, contract);
	}
	
	@Override
	public void addContractLine(Contract contract, ContractLine contractLine) {
		contract.getContractLine().add(contractLine);
		dao.save(contract);
	}
	
	@Override
	public void removeContractLine(Contract contract, ContractLine contractLine) {
		contract.getContractLine().remove(contractLine);
		dao.save(contract);
	}
}
