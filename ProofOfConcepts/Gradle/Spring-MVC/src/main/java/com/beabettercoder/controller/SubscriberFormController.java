package com.beabettercoder.controller;

import javax.validation.Valid;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.beabettercoder.dao.SubscriberDao;
import com.beabettercoder.entities.Subscriber;
import com.beabettercoder.entities.Subscriber.Frequency;
import com.beabettercoder.entities.Subscriber.Gender;
import com.beabettercoder.springconfig.WebConfiguration;

@Controller
public class SubscriberFormController {
	
	 AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
	 
	@ModelAttribute("frequencies")
	public Frequency[] frequencies() {
		return Frequency.values();
	}
	
	@ModelAttribute("genders")
	public Gender[] personGender() {
		return Gender.values();
	}

	@RequestMapping(value="form", method=RequestMethod.GET)
	public String loadFormPage(Model m) {
		m.addAttribute("subscriber", new Subscriber());
		return "formPage";
	}
	
	@RequestMapping(value="form", method=RequestMethod.POST)
	public String submitForm(@ModelAttribute @Valid Subscriber subscriber,BindingResult result, Model m) {
		m.addAttribute("message", "Successfully saved person: " + subscriber.toString());
		ctx.register(WebConfiguration.class);
		//@TODO fix refresher only once issue
		ctx.refresh();
		SubscriberDao sao = ctx.getBean(SubscriberDao.class);
		sao.savePerson(subscriber);
		return "formPage";
	}
}
