package com.fot.backConTask.service.user;

import org.springframework.stereotype.Service;

import com.fot.backConTask.dao.UserDAO;
import com.fot.backConTask.model.User;
import com.fot.backConTask.service.AbstractService;

@Service
public class UserServiceImpl extends AbstractService<User, UserDAO> implements UserService{

}
