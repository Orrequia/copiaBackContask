package com.fot.backcontask.service.role;

import org.springframework.stereotype.Service;

import com.fot.backcontask.dao.RoleDAO;
import com.fot.backcontask.model.Role;
import com.fot.backcontask.service.AbstractService;

@Service
public class RoleServiceImpl extends AbstractService<Role, RoleDAO> implements RoleService {

}
