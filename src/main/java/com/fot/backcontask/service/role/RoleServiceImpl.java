package com.fot.backcontask.service.role;

import org.springframework.stereotype.Service;

import com.fot.backcontask.dao.RoleDAO;
import com.fot.backcontask.exception.NotFoundException;
import com.fot.backcontask.model.Role;
import com.fot.backcontask.service.AbstractService;

@Service
public class RoleServiceImpl extends AbstractService<Role, RoleDAO> implements RoleService {

	@Override
	public Role getAndCheck(Long id) throws NotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isEqual(Role u1, Role u2) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void setValues(Role to, Role from) {
		// TODO Auto-generated method stub
		
	}

}
