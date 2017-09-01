package com.eschool.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.eschool.domain.Department;
import com.eschool.domain.Employee;
import com.eschool.domain.RoleData;
import com.eschool.dto.DepartmentDTO;
import com.eschool.dto.aaData;
import com.eschool.service.AccountDataService;
import com.eschool.service.DepartmentDataService;
import com.eschool.service.RoleDataService;
import com.fasterxml.jackson.databind.ser.std.MapProperty;

@Controller
@RequestMapping("/department")
@Validated
public class DepartmentController {
    
    @Autowired
    private DepartmentDataService deptService;
    

    @PostMapping(value = "/create-department")
    @ResponseBody
    public String createStaff(@ModelAttribute DepartmentDTO departmentDTO,
            BindingResult result) {
    	
    	Department department = new Department();
		department.setCode(departmentDTO.getCode());
		department.setName(departmentDTO.getName());
		
		
    	if(departmentDTO.getId() == null){
    		deptService.create(department);
    	}else{
    		department.setId(departmentDTO.getId());
    		deptService.update(department);
    	}
    	return "department created successfully";
    }
   
    @GetMapping(value = "/get-departments")
    @ResponseBody
    public ResponseEntity<aaData<DepartmentDTO>> getAllManagersForDataTable(@RequestParam(value = "sEcho") int sEcho,
                                                                                   @RequestParam(value = "sSearch", defaultValue = "") String sSearch,
                                                                                   @RequestParam(value = "iDisplayStart") int iDisplayStart,
                                                                                   @RequestParam(value = "iDisplayLength") int iDisplayLength,
                                                                                   @RequestParam(value = "iSortCol_0", defaultValue = "0") int iSortCol_0,
                                                                                   @RequestParam(value = "sSortDir_0", defaultValue = "ASC") String sSortDir_0) {
        final List<Sort.Order> orders = new ArrayList<>();
        final Sort.Direction direction = Sort.Direction.fromStringOrNull(sSortDir_0);
        orders.add(new Sort.Order(direction, "name", Sort.NullHandling.NULLS_LAST));
        
        List<Department> listData = deptService.findAll();
        List<DepartmentDTO> retList = new ArrayList<DepartmentDTO>(0);
        for (Department department : listData) {
        	DepartmentDTO dto = new DepartmentDTO(department.getId(),department.getCode(),department.getName());
        	retList.add(dto);
		}
        
        final aaData<DepartmentDTO> aData = new aaData<DepartmentDTO>();
        aData.setAaData(retList);
        aData.setiTotalDisplayRecords( retList.size());
        aData.setiTotalRecords(retList.size());
        aData.setsEcho(sEcho);
        aData.setiDisplayStart(iDisplayStart);
        aData.setiDisplayLength(iDisplayLength);

        return ResponseEntity.ok(aData);
    }

    @RequestMapping(value = "/delete-department", method = RequestMethod.GET)
    @ResponseBody
    public String deleteRole(@ModelAttribute DepartmentDTO dto) {
    	
       String strReturnMessage = "department deleted successfully";
       Department department = deptService.findOne(dto.getId());  
       if(department == null) {
    	   strReturnMessage = "department does not exists";
       } else {
    	   deptService.delete(department);
       }
       return strReturnMessage;
    }
   
}