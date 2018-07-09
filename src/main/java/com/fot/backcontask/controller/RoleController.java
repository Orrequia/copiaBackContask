package com.fot.backcontask.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fot.backcontask.dto.role.RoleDTO;
import com.fot.backcontask.model.Role;

@RestController
@RequestMapping("/role")
public class RoleController extends AbstractController<Role, RoleDTO>{

}
