package com.eschool.controller;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.eschool.common.CommonHelper;
import com.eschool.domain.Employee;

@Controller
public class IndexController {
    private final Logger logger = LoggerFactory.getLogger(getClass());

    @RequestMapping(value = {"/", "index", "index.html"})
    public String getHome(final HttpSession httpSession) {
        final Employee accountData = CommonHelper.getAccount();
        if (accountData == null) {
            return "redirect:/login";
        }
        httpSession.setAttribute("pId", accountData.getId());

       /* if("hr".equalsIgnoreCase(accountData.getRole().getName())){
        	return "redirect:/hr";
        }if("manager".equalsIgnoreCase(accountData.getRole().getName())){
        	return "redirect:/manager";
        }else{*/
        	return "redirect:/" + accountData.getAccounttype().toLowerCase();
        //}
        
    }
}