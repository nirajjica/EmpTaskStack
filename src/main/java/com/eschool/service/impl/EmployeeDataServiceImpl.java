package com.eschool.service.impl;

import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.eschool.domain.Department;
import com.eschool.domain.Employee;
import com.eschool.repository.DepartmentDataRepository;
import com.eschool.repository.EmployeeDataRepository;
import com.eschool.service.DepartmentDataService;
import com.eschool.service.EmployeeDataService;
import com.eschool.service.common.AbstractService;

@Service
public class EmployeeDataServiceImpl implements EmployeeDataService{
	
	@Autowired
    private Mapper mapper;
	
	@Autowired
	EmployeeDataRepository repo;
	
	@Override
	public JpaRepository<Employee, Integer> getRepository() {
		// TODO Auto-generated method stub
		return repo;
	}

}
