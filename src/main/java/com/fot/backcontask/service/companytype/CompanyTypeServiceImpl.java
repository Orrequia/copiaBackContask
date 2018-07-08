package com.fot.backcontask.service.companytype;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import com.fot.backcontask.dao.CompanyTypeDAO;
import com.fot.backcontask.exception.NotFoundException;
import com.fot.backcontask.model.CompanyType;
import com.fot.backcontask.service.AbstractService;

@Service
public class CompanyTypeServiceImpl extends AbstractService<CompanyType, CompanyTypeDAO> implements CompanyTypeService {

	@Override
	public CompanyType getAndCheck(Long id) throws NotFoundException {
		return findById(id).orElseThrow(() -> new NotFoundException("El tipo de compañía no existe"));
	}

	@Override
	public boolean isEqual(CompanyType ct1, CompanyType ct2) {
		return StringUtils.equals(ct1.getName(), ct2.getName());
	}

	@Override
	public void setValues(CompanyType to, CompanyType from) {
		to.setName(from.getName());
	}

}
