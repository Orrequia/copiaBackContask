package com.fot.backcontask.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fot.backcontask.dto.company.CompanyTypeDTO;
import com.fot.backcontask.model.CompanyType;

@RestController
@RequestMapping("/companyType")
class CompanyTypeController extends AbstractController<CompanyType, CompanyTypeDTO> {

}
