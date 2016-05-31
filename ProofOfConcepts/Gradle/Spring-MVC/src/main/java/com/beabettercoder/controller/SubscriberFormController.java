package com.beabettercoder.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.util.UriComponentsBuilder;

import com.beabettercoder.dao.SubscriberDao;
import com.beabettercoder.entities.Subscriber;
import com.beabettercoder.entities.Subscriber.Frequency;
import com.beabettercoder.entities.Subscriber.Gender;

//@TODO look into spring security

@Controller
public class SubscriberFormController {
		
	@Autowired
    private SubscriberDao subsDao;
	
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
	
	@RequestMapping(value="uform", method=RequestMethod.GET)
	public String loadUFormPage(Model m) {
		return "userManagment";
	}
	
	//note to self
	//hibernate validation requires valid email address and phone number to be passed
    @RequestMapping(value = "uform", method = RequestMethod.POST)
    public @ResponseBody Subscriber createUser(@RequestBody Subscriber subs,   UriComponentsBuilder ucBuilder) {
//        System.out.println("Creating User " + user.getName());
    	System.out.println(subs.toString());
    	System.out.println("in here");
    	// setting some constraint data to handle hibernate validation errors
    	subs.setGender(Gender.FEMALE);
    	subs.setAge(21);  //greater than 13 and less than 110
    	subsDao.savePerson(subs);
        return subs;
    }
  
	
	//@TODO hibernate broke validity
	//@TODO disable submit until data is valid
	@RequestMapping(value="form", method=RequestMethod.POST)
	public String submitForm(@ModelAttribute @Valid Subscriber subscriber,BindingResult result, Model m) {
		m.addAttribute("message", "Successfully saved person: " + subscriber.toString());
		subsDao.savePerson(subscriber);
		return "formPage";
	}
}
