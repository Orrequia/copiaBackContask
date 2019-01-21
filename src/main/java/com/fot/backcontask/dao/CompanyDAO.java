package com.fot.backcontask.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.fot.backcontask.model.Company;

import java.util.List;

@Repository
public interface CompanyDAO extends GenericDAO<Company> {

    List<Company> findByNameContainingIgnoreCaseOrNifContainingIgnoreCaseOrNoteContainingIgnoreCase(String name, String nif, String note);

    @Query(value = "SELECT c FROM Company AS c JOIN c.store AS s WHERE LOWER(s.name) LIKE %:name% OR s.phone LIKE %:phone% OR LOWER(s.email) LIKE %:email%")
    List<Company> findByStoreFields(@Param("name") String name, @Param("phone") String phone, @Param("email") String email);

    @Query(value = "SELECT c FROM Company AS c JOIN c.store AS s JOIN s.employee AS e WHERE e.phone LIKE %:phone% OR LOWER(e.email) LIKE %:email%")
    List<Company> findByEmployeeFields(@Param("phone") String phone, @Param("email") String email);

    @Query(value = "SELECT c FROM Company AS c JOIN c.owner AS e WHERE e.phone LIKE %:phone% OR LOWER(e.email) LIKE %:email%")
    List<Company> findByOwnerFields(@Param("phone") String phone, @Param("email") String email);
}
