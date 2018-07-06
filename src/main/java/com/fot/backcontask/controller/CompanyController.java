package com.fot.backcontask.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fot.backcontask.component.mapper.company.CompanyMapper;
import com.fot.backcontask.dto.company.CompanyDTO;
import com.fot.backcontask.model.Company;

@RestController
@RequestMapping("/company")
public class CompanyController extends AbstractController<Company, CompanyDTO, CompanyMapper> {

	@Override
	public Class<CompanyDTO> clazz() {
		return CompanyDTO.class;
	}

}
