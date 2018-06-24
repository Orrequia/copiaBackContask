package com.fot.backcontask.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fot.backcontask.service.user.UserService;

@RestController
@RequestMapping(value= "/user")
public class UserController {

	@Autowired
	UserService userService;
	
	@Autowired
	UserMapper userMapper;
}
