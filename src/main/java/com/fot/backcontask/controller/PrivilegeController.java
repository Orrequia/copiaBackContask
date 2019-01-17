package com.fot.backcontask.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fot.backcontask.dto.privilege.PrivilegeDTO;
import com.fot.backcontask.model.Privilege;

@RestController
@RequestMapping("/privilege")
class PrivilegeController extends AbstractController<Privilege, PrivilegeDTO>{
	
}
