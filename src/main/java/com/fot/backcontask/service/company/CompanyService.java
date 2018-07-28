package com.fot.backcontask.service.company;

import com.fot.backcontask.model.Company;
import com.fot.backcontask.model.Contract;
import com.fot.backcontask.model.Store;
import com.fot.backcontask.service.Service;

public interface CompanyService extends Service<Company, Long> {
	
	void addStore(Company company, Store store);
	void removeStore(Company company, Store store);
	
	void addContract(Company company, Contract contract);
	void removeContract(Company company, Contract contract);
}
