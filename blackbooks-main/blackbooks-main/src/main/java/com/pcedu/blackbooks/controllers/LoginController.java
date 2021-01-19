package com.pcedu.blackbooks.controllers;

import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/")
public class LoginController {

    @RequestMapping(value = {"/"}, method = {RequestMethod.GET})
    public String login(ModelMap view) {
//        view.addAttribute("projectName", "Grocery Store");
//        String message = "";
//        view.addAttribute("msg", message);
        return "hi!!";
    }
    
//    @RequestMapping(value = {"/login"}, method = {RequestMethod.GET})
//    public String login(ModelMap view, @RequestParam(required = false) String msg) {
//        view.addAttribute("projectName", "Grocery Store");
//        view.addAttribute("msg", msg);
//        return ("login");
//    }
}
