package com.eschool.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.eschool.domain.RoleData;
import com.eschool.repository.RoleDataRepository;
import com.eschool.service.RoleDataService;

@Service
public class RoleDataServiceImpl implements RoleDataService {

    @Autowired
    private RoleDataRepository repository;
  
    @Override
    public JpaRepository<RoleData, String> getRepository() {
        return repository;
    }
}
