package com.beabettercoder.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.beabettercoder.forms.Subscriber;
import com.beabettercoder.forms.Subscriber.Frequency;
import com.beabettercoder.forms.Subscriber.Gender;

@Controller
public class SubscriberFormController {
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
	public String submitForm(@ModelAttribute Subscriber subscriber, Model m) {
		m.addAttribute("message", "Successfully saved person: " + subscriber.toString());
		return "formPage";
	}
}
