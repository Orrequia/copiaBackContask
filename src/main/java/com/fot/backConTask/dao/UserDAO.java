package com.fot.backConTask.dao;

import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.fot.backConTask.model.User;

@Repository
public interface UserDAO extends GenericDAO<User> {

	public Optional<User> findOneByUsernameAndPassword(String username, String password);
}
