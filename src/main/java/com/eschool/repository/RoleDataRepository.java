package com.eschool.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.eschool.domain.RoleData;


public interface RoleDataRepository extends JpaRepository<RoleData, String> {

}