package com.eschool.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.eschool.domain.Employee;
import com.eschool.domain.RoleData;

import java.util.List;

public interface AccountDataRepository extends JpaRepository<Employee, Integer> {
    Employee findByUsername(String username);

    @Query(value = "SELECT a FROM Employee a WHERE a.visible<>'D' and " +
            "LOWER(a.accounttype) = LOWER(:accounttype) and " +
            "LOWER(a.accountstatus) = LOWER(:accountstatus)")
    List<Employee> findByAccounttypeAndAccountstatus(@Param("accounttype") String accounttype,@Param("accountstatus")  String accountstatus);
    List<Employee> findByRole(RoleData name);
    Employee findByEmail(String email);
    List<Employee> findByAccounttype(String type);

    
    @Query(value = "SELECT a FROM Employee a WHERE a.username = :username and a.password = :password ")
    Employee findByUserAndPassword(@Param("username") String username,@Param("password")  String password);

}