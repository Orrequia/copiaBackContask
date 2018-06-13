package com.fot.backConTask.service.contract;

import org.springframework.stereotype.Service;

import com.fot.backConTask.dao.ContractDAO;
import com.fot.backConTask.model.Contract;
import com.fot.backConTask.service.AbstractService;

@Service
public class ContractServiceImpl extends AbstractService<Contract, ContractDAO> implements ContractService {

}
