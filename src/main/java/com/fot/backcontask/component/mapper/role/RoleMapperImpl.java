package com.fot.backcontask.component.mapper.role;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fot.backcontask.component.mapper.AbstractMapper;
import com.fot.backcontask.dto.role.RoleDTO;
import com.fot.backcontask.exception.NotFoundException;
import com.fot.backcontask.model.Privilege;
import com.fot.backcontask.model.Role;
import com.fot.backcontask.service.privilege.PrivilegeService;

@Component
@AllArgsConstructor(onConstructor_={@Autowired})
public class RoleMapperImpl extends AbstractMapper<Role, RoleDTO> implements RoleMapper {

	final PrivilegeService privilegeService;
	
	@Override
	public Class<? extends RoleDTO> dtoClazz() {
		return RoleDTO.class;
	}

	@Override
	public Class<? extends Role> modelClazz() {
		return Role.class;
	}

	@Override
	public Role dtoToModel(RoleDTO dto) throws NotFoundException {
		return map(dto, longToPrivilege(dto.getPrivileges()));
	}
	
	private List<Privilege> longToPrivilege(List<Long> privileges) throws NotFoundException {
		if(privileges != null) {
			List<Privilege> privilege = privileges.stream().map(privilegeService::findById)
					.filter(Optional::isPresent)
					.map(Optional::get)
					.collect(Collectors.toList());
			if(privilege.size() != privileges.size()) throw new NotFoundException("Algunos o todos los privilegios no existen");
			return privilege;
		}
		return new ArrayList<>();
	}
	
	private Role map(RoleDTO dto, List<Privilege> privilege) {
		Role role = dozer.map(dto, modelClazz());
		role.setPrivilege(privilege);
		return role;
	}

	@Override
	public RoleDTO modelToDto(Role model) {
		return map(model, privilegeToLong(model.getPrivilege()));
	}
	
	private List<Long> privilegeToLong(List<Privilege> privilege) {
		return privilege.stream().map(Privilege::getIdPrivilege).collect(Collectors.toList());
	}
	
	private RoleDTO map(Role model, List<Long> privileges) {
		RoleDTO roleDTO = dozer.map(model, dtoClazz());
		roleDTO.setPrivileges(privileges);
		return roleDTO;
	}
}
