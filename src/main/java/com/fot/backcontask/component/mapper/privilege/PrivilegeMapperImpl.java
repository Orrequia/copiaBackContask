package com.fot.backcontask.component.mapper.privilege;

import org.springframework.stereotype.Component;

import com.fot.backcontask.component.mapper.AbstractMapper;
import com.fot.backcontask.dto.privilege.PrivilegeDTO;
import com.fot.backcontask.model.Privilege;

@Component
public class PrivilegeMapperImpl extends AbstractMapper<Privilege, PrivilegeDTO> implements PrivilegeMapper {

	@Override
	public Class<? extends PrivilegeDTO> dtoClazz() {
		return PrivilegeDTO.class;
	}

	@Override
	public Class<? extends Privilege> modelClazz() {
		return Privilege.class;
	}

}
