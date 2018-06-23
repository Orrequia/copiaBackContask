package com.fot.backcontask.service.company;

import org.springframework.stereotype.Service;

import com.fot.backcontask.dao.CompanyDAO;
import com.fot.backcontask.model.Company;
import com.fot.backcontask.service.AbstractService;

@Service
public class CompanyServiceImpl extends AbstractService<Company, CompanyDAO> implements CompanyService {

}
