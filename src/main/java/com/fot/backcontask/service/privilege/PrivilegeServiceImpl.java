package com.fot.backcontask.service.privilege;

import org.springframework.stereotype.Service;

import com.fot.backcontask.dao.PrivilegeDAO;
import com.fot.backcontask.exception.NotFoundException;
import com.fot.backcontask.model.Privilege;
import com.fot.backcontask.service.AbstractService;

@Service
public class PrivilegeServiceImpl extends AbstractService<Privilege, PrivilegeDAO> implements PrivilegeService {

	@Override
	public Privilege getAndCheck(Long id) throws NotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isEqual(Privilege u1, Privilege u2) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void setValues(Privilege to, Privilege from) {
		// TODO Auto-generated method stub
		
	}

}
