package com.eschool.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class SecurityController {
    private final Logger logger = LoggerFactory.getLogger(getClass());

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(@RequestParam(value = "error", defaultValue = "false") boolean error, Model model) {
        model.addAttribute("error", error);
        return "login";
    }
    
    @RequestMapping(value = "/hr", method = RequestMethod.GET)
    public String viewHr(Model model) {
        return "hr";
    }
    
    @RequestMapping(value = "/manager", method = RequestMethod.GET)
    public String managerPage(Model model) {
        return "manager";
    }
    

}