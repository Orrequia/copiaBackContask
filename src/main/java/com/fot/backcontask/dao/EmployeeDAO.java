package com.fot.backcontask.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.fot.backcontask.model.Employee;

import java.util.List;
import java.util.Optional;

@Repository
public interface EmployeeDAO extends GenericDAO<Employee> {

    @Query(value = "SELECT e FROM Store AS s JOIN s.employee AS e WHERE s.idStore = :idStore")
    List<Employee> findByStore(@Param("idStore") Long store);
}
