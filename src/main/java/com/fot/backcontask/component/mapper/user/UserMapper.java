package com.fot.backcontask.component.mapper.user;

import com.fot.backcontask.component.mapper.Mapper;
import com.fot.backcontask.dto.user.UserDTO;
import com.fot.backcontask.dto.user.UserPostDTO;
import com.fot.backcontask.exception.NotFoundException;
import com.fot.backcontask.model.User;

public interface UserMapper extends Mapper<User, UserDTO>{
	
	User dtoToModel(UserPostDTO dto) throws NotFoundException;
}
