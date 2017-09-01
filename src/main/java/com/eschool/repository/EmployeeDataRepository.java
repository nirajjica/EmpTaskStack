package com.eschool.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.eschool.domain.Employee;

public interface EmployeeDataRepository extends JpaRepository<Employee, Integer>{

}
