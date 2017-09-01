package com.eschool.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.eschool.domain.Department;
import com.eschool.domain.Employee;
import com.eschool.domain.RoleData;
import com.eschool.dto.EmployeeDTO;
import com.eschool.dto.aaData;
import com.eschool.service.AccountDataService;
import com.eschool.service.DepartmentDataService;
import com.eschool.service.EmployeeDataService;
import com.eschool.service.RoleDataService;

@Controller
@RequestMapping("/employee")
@Validated
public class EmployeeController {
    
	@Autowired
	private AccountDataService  accountDataService;
	
	@Autowired
	private EmployeeDataService employeeDataService;
	
	@Autowired
    private DepartmentDataService deptService;
	
	@Autowired
	private RoleDataService roleDataService;
	
	@PostMapping(value = "/create-employee")
    @ResponseBody
    public String createEmployee(@ModelAttribute EmployeeDTO employeeDTO) {
    	
		Employee employee = new Employee();
		
		employee.setFname(employeeDTO.getFname());
		employee.setLname(employeeDTO.getLname());
		employee.setEmail(employeeDTO.getEmail());
		employee.setAddress(employeeDTO.getAddress());
		employee.setPhone(employeeDTO.getPhone());
		employee.setPassword(employeeDTO.getPassword());
		employee.setUsername(employeeDTO.getUsername());
		employee.setCode(employeeDTO.getCode());
		
		Department  department = deptService.findOne(new Integer(employeeDTO.getDepartmentId()));
		employee.setDepartment(department);

		RoleData roleData =  roleDataService.findOne(employeeDTO.getRoleName());
		employee.setRole(roleData);
		
		if(employeeDTO.getManager() !=  null){
			Employee employee2 = employeeDataService.findOne(new Integer(employeeDTO.getManager()));
			employee.setEmployee(employee2);
		}
		
		employee.setCreatedate(new Date());
		employee.setAccounttype(employeeDTO.getAccounttype());
		employee.setAccountstatus("ACTIVE");
		employee.setSalary(new Double(employeeDTO.getSalary()));
		 
		if(employeeDTO.getId() == null){
			employeeDataService.create(employee);
		}else{
			employee.setId(employeeDTO.getId());
			employeeDataService.update(employee);
		}
		
		return "employee created successfully";
    }

    @RequestMapping(value = "/list-employee", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<aaData<EmployeeDTO>> getAllManagersForDataTable(@RequestParam(value = "sEcho") int sEcho,
                                                                                   @RequestParam(value = "sSearch", defaultValue = "") String sSearch,
                                                                                   @RequestParam(value = "iDisplayStart") int iDisplayStart,
                                                                                   @RequestParam(value = "iDisplayLength") int iDisplayLength,
                                                                                   @RequestParam(value = "iSortCol_0", defaultValue = "0") int iSortCol_0,
                                                                                   @RequestParam(value = "sSortDir_0", defaultValue = "ASC") String sSortDir_0) {
        final List<Sort.Order> orders = new ArrayList<>();
        final Sort.Direction direction = Sort.Direction.fromStringOrNull(sSortDir_0);
        orders.add(new Sort.Order(direction, "name", Sort.NullHandling.NULLS_LAST));
        List<Employee> listCompanyData = employeeDataService.findAll();
        List<EmployeeDTO> listDtos = new ArrayList<EmployeeDTO>();
        for (Employee employee : listCompanyData) {
			EmployeeDTO employeeDTO = new EmployeeDTO(employee.getId(), employee.getCode(), employee.getFname(), employee.getLname(), employee.getEmail(), employee.getAddress(), employee.getSalary().toString(), employee.getPassword(), employee.getUsername(), employee.getPhone(), employee.getAccounttype(), employee.getCreatedate().toString(), employee.getAccountstatus(), employee.getDepartment().getId().toString(), employee.getRole().getName());
			if(employee.getEmployee() != null)
				employeeDTO.setManager(employee.getEmployee().getId().toString());
			listDtos.add(employeeDTO);
		}
        
        
        final aaData<EmployeeDTO> aData = new aaData<EmployeeDTO>();
        
        aData.setAaData(listDtos);
        aData.setiTotalDisplayRecords( listDtos.size());
        aData.setiTotalRecords(listDtos.size());
        aData.setsEcho(sEcho);
        aData.setiDisplayStart(iDisplayStart);
        aData.setiDisplayLength(iDisplayLength);

        return ResponseEntity.ok(aData);
    }

    @RequestMapping(value = "/delete-employee", method = RequestMethod.GET)
    @ResponseBody
    public String deleteEmployee(@RequestParam(value="id") String id) {
    	
       String strReturnMessage = "Employee deleted successfully";
       Employee accountData = employeeDataService.findOne(new Integer(id));  
       if(accountData == null) {
    	   strReturnMessage = "Employee does not exists";
       } else {
    	   employeeDataService.delete(accountData);
       }
       return strReturnMessage;
    }
   
}