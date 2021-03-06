package com.fot.backcontask.component.mapper.user;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fot.backcontask.component.mapper.AbstractMapper;
import com.fot.backcontask.dto.user.UserDTO;
import com.fot.backcontask.dto.user.UserPostDTO;
import com.fot.backcontask.exception.NotFoundException;
import com.fot.backcontask.model.Role;
import com.fot.backcontask.model.User;
import com.fot.backcontask.service.role.RoleService;

@Component
@AllArgsConstructor(onConstructor_={@Autowired})
public class UserMapperImpl extends AbstractMapper<User, UserDTO> implements UserMapper {

	private final RoleService roleService;
	
	@Override
	public Class<? extends UserDTO> dtoClazz() {
		return UserDTO.class;
	}

	@Override
	public Class<? extends User> modelClazz() {
		return User.class;
	}
	
	@Override
	public User dtoToModel(UserPostDTO dto) throws NotFoundException {
		Role role = longToRole(dto.getIdRole());
		return map(dto, role);
	}
	
	private Role longToRole(Long idRole) throws NotFoundException {
			return roleService.findById(idRole)
					.orElseThrow(() -> new NotFoundException("El rol no existe"));	
	}
	
	private User map(UserPostDTO dto, Role role) {
		User user = dozer.map(dto, modelClazz());
		user.setRole(role);
		return user;
	}

}
