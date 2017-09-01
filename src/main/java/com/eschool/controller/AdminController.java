package com.eschool.controller;


import java.util.Map;

import javax.validation.Valid;

import org.dozer.Mapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.eschool.common.CommonHelper;
import com.eschool.domain.Employee;
import com.eschool.dto.AccountDataDTO;
import com.eschool.service.AccountDataService;


@Controller
@RequestMapping("/admin")
@Validated
public class AdminController {
    private final Logger logger = LoggerFactory.getLogger(getClass());
    
    @Autowired
    private Mapper mapper;
    
    @Autowired
    private AccountDataService accountDataService;


    @RequestMapping(value = "", method = RequestMethod.GET)
    public String view(Model model) {

        return "admin";
    }
    
    @RequestMapping(value = "/createManager", method = RequestMethod.POST)
    @ResponseBody
    public ModelAndView createManager(@Valid @ModelAttribute("accountDataDTO") AccountDataDTO accountDataDTO, BindingResult result, Map<String, Object> map) {
        final ModelAndView mv = new ModelAndView("admin/createManagerForm");
        if (result.hasErrors()) {
            map.put("accountDataDTO", accountDataDTO);
            return mv;
        }
        accountDataDTO.setAccounttype("MANAGER");
        accountDataDTO.setParentId(CommonHelper.getAccount().getId());
        try {
            accountDataService.create(accountDataDTO);
        } catch (Exception e) {
            map.put("errorMsg", "Error in submitting Manager");
            mv.addObject("accountDataDTO", accountDataDTO);
            return mv;
        }
        map.put("successMsg", "Manager Successfully Created");
        mv.addObject("accountDataDTO", new AccountDataDTO());
        return mv;
    }

 
    @RequestMapping(value = "/check-unique-username", method = RequestMethod.GET)
    @ResponseBody
    public String checkUniqueUserName(@RequestParam("username") String username) {
        String resultStr = "";
        try {
            accountDataService.loadUserByUsername(username);
            resultStr += "User name (" + username + ") already exist";
        } catch (UsernameNotFoundException e) {
            resultStr += "User name (" + username + ") available";
        }
        return resultStr;
    }

    
}