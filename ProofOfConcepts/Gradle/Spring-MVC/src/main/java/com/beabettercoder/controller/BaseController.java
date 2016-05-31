package com.beabettercoder.controller;

import javax.servlet.http.HttpServlet;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * This is the intial controller I created to better 
 * understand the usage of controller class to route any incoming req
 * to specific jsp to display
 * 
 * This also exhibits passing specific attributes to same page based on 
 * different URL
 * @author praveen
 *
 */
@Controller
public class BaseController{
	 
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@RequestMapping("home")
    public String loadHomePage(Model m) {
        m.addAttribute("name", "CodeTutr2");
        return "home";
    }
	
	@RequestMapping("home2")
    public String loadHomePage2(Model m) {
        m.addAttribute("name", "beabettercoder");
        return "home";
    }
	
	@RequestMapping("")
    public String loadDefault(Model m) {
        m.addAttribute("name", "default");
        return "home";
    }
}
