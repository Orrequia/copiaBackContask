package com.fot.backcontask.service.contract;

import org.springframework.stereotype.Service;

import com.fot.backcontask.dao.ContractDAO;
import com.fot.backcontask.model.Contract;
import com.fot.backcontask.service.AbstractService;

@Service
public class ContractServiceImpl extends AbstractService<Contract, ContractDAO> implements ContractService {

}
