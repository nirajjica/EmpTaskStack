package com.eschool.service;


import java.util.List;
import org.springframework.security.core.userdetails.UserDetailsService;

import com.eschool.domain.Employee;
import com.eschool.domain.RoleData;
import com.eschool.dto.AccountDataDTO;
import com.eschool.service.common.AbstractService;

public interface AccountDataService extends UserDetailsService, AbstractService<Employee, Integer> {
    Employee create(AccountDataDTO accountDataDTO);
    List<Employee> findByRole(RoleData name);
    List<Employee> findByAccounttype(String type);
    Employee findByUsername(String username);
    Employee findByEmail(String email);
	Employee findByUserAndPassword(String username, String password);
    
    

}
