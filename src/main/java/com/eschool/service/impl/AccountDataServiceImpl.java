package com.eschool.service.impl;

import org.dozer.Mapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.eschool.domain.Employee;
import com.eschool.domain.RoleData;
import com.eschool.dto.AccountDataDTO;
import com.eschool.repository.AccountDataRepository;
import com.eschool.service.AccountDataService;

import java.util.Date;
import java.util.List;

@Service
public class AccountDataServiceImpl implements AccountDataService {
    private final Logger logger = LoggerFactory.getLogger(getClass());
    @Autowired
    private Mapper mapper;
    @Autowired
    private AccountDataRepository repository;
  
    @Override
    public JpaRepository<Employee, Integer> getRepository() {
        return repository;
    }

    @Transactional(readOnly = true)
    @Override
    public UserDetails loadUserByUsername(final String username) throws UsernameNotFoundException {
        Employee accountData = repository.findByUsername(username);
        if (accountData == null) {
            throw new UsernameNotFoundException(username);
        }
        return accountData;
    }
    
	@Transactional(readOnly = true)
	@Override
	public Employee findByUserAndPassword(String username, String password) {
		return repository.findByUserAndPassword(username, password);
	}
    @Override
    public Employee create(AccountDataDTO accountDataDTO) {
        accountDataDTO.setId(null);
        accountDataDTO.setCreatedate(new Date());
        accountDataDTO.setWelcomeEmailSent("Y");
        accountDataDTO.setVisible('Y');
        accountDataDTO.setWelcomeEmailSent("N");
        accountDataDTO.setAccountstatus("ACTIVE");
        accountDataDTO.setSystemgenerated("Y");
        Employee accountData = mapper.map(accountDataDTO, Employee.class);
        return create(accountData);
    }

    @Transactional(readOnly = true)
	@Override
	public List<Employee> findByRole(RoleData name) {
		return repository.findByRole(name);
	}

	@Override
	public Employee findByUsername(String username) {
		return repository.findByUsername(username);
	}

	@Override
	public Employee findByEmail(String email) {
		return repository.findByEmail(email);
	}

	@Override
	public List<Employee> findByAccounttype(String type) {
		return repository.findByAccounttype(type);
	}

}
