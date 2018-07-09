package com.fot.backcontask.service.privilege;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import com.fot.backcontask.dao.PrivilegeDAO;
import com.fot.backcontask.exception.NotFoundException;
import com.fot.backcontask.model.Privilege;
import com.fot.backcontask.service.AbstractService;

@Service
public class PrivilegeServiceImpl extends AbstractService<Privilege, PrivilegeDAO> implements PrivilegeService {

	@Override
	public Privilege getAndCheck(Long id) throws NotFoundException {
		return findById(id).orElseThrow(() -> new NotFoundException("El privilegio no existe"));
	}

	@Override
	public boolean isEqual(Privilege p1, Privilege p2) {
		return StringUtils.equals(p1.getName(), p2.getName());	
	}

	@Override
	public void setValues(Privilege to, Privilege from) {
		to.setName(from.getName());
	}
}
