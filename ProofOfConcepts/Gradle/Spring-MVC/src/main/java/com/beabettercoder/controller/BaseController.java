package com.beabettercoder.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BaseController {
	 
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
