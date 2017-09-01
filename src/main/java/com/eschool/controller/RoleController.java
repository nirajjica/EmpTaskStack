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
import com.eschool.dto.RoleDataDTO;
import com.eschool.dto.aaData;
import com.eschool.service.AccountDataService;
import com.eschool.service.DepartmentDataService;
import com.eschool.service.RoleDataService;
import com.fasterxml.jackson.databind.ser.std.MapProperty;

@Controller
@RequestMapping("/role")
@Validated
public class RoleController {
    
    @Autowired
    private DepartmentDataService deptService;
    
    @Autowired
    private RoleDataService roleDataService;

    @PostMapping(value = "/create-role")
    @ResponseBody
    public String createStaff(@ModelAttribute RoleDataDTO roleDataDto,
            BindingResult result) {
    	
    	RoleData roleData = new RoleData();
    	roleData.setName(roleDataDto.getName());
    	roleData.setMenus(roleDataDto.getMenus());
		
    	RoleData roleDataDb = roleDataService.findOne(roleData.getName());
    	if(roleDataDb == null){
    		roleDataService.create(roleData);
    	}else{
    		roleDataService.update(roleData);
    	}
    	return "role created successfully";
    }
   
    @GetMapping(value = "/get-role")
    @ResponseBody
    public ResponseEntity<aaData<RoleDataDTO>> getAllManagersForDataTable(@RequestParam(value = "sEcho") int sEcho,
                                                                                   @RequestParam(value = "sSearch", defaultValue = "") String sSearch,
                                                                                   @RequestParam(value = "iDisplayStart") int iDisplayStart,
                                                                                   @RequestParam(value = "iDisplayLength") int iDisplayLength,
                                                                                   @RequestParam(value = "iSortCol_0", defaultValue = "0") int iSortCol_0,
                                                                                   @RequestParam(value = "sSortDir_0", defaultValue = "ASC") String sSortDir_0) {
        final List<Sort.Order> orders = new ArrayList<>();
        final Sort.Direction direction = Sort.Direction.fromStringOrNull(sSortDir_0);
        orders.add(new Sort.Order(direction, "name", Sort.NullHandling.NULLS_LAST));
        
        List<RoleData> listData = roleDataService.findAll();
        List<RoleDataDTO> retList = new ArrayList<RoleDataDTO>(0);
        for (RoleData roleData : listData) {
        	RoleDataDTO roleDataDTO = new RoleDataDTO();
        	roleDataDTO.setName(roleData.getName());
        	roleDataDTO.setMenus(roleData.getMenus());
        	retList.add(roleDataDTO);
		}
        
        final aaData<RoleDataDTO> aData = new aaData<RoleDataDTO>();
        aData.setAaData(retList);
        aData.setiTotalDisplayRecords( retList.size());
        aData.setiTotalRecords(retList.size());
        aData.setsEcho(sEcho);
        aData.setiDisplayStart(iDisplayStart);
        aData.setiDisplayLength(iDisplayLength);

        return ResponseEntity.ok(aData);
    }

    @RequestMapping(value = "/delete-role", method = RequestMethod.GET)
    @ResponseBody
    public String deleteRole(@ModelAttribute RoleDataDTO dto) {
    	
       String strReturnMessage = "role deleted successfully";
       RoleData roleData = roleDataService.findOne(dto.getName());  
       if(roleData == null) {
    	   strReturnMessage = "role does not exists";
       } else {
    	   roleDataService.delete(roleData);
       }
       return strReturnMessage;
    }
   
}