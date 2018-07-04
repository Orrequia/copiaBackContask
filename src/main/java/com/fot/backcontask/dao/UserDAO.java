package com.fot.backcontask.dao;

import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.fot.backcontask.model.User;

@Repository
public interface UserDAO extends GenericDAO<User> {

	public Optional<User> findOneByUsername(String username);
}
