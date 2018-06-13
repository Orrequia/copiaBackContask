package com.fot.backConTask.service.company;

import org.springframework.stereotype.Service;

import com.fot.backConTask.dao.CompanyDAO;
import com.fot.backConTask.model.Company;
import com.fot.backConTask.service.AbstractService;

@Service
public class CompanyServiceImpl extends AbstractService<Company, CompanyDAO> implements CompanyService {

}
