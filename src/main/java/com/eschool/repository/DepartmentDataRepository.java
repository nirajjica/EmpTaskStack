package com.eschool.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.eschool.domain.Department;

public interface DepartmentDataRepository extends JpaRepository<Department, Integer>{

}
