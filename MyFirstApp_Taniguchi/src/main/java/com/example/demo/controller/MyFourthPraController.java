package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MyFourthPraController {
	
	@RequestMapping(path = "/fourthprapra", method = RequestMethod.GET)
	public String fourthpra() {
		return "myfourthpra";
	}
	

	@RequestMapping(path = "/fourthprapra", method = RequestMethod.POST)
	public String fourthpra(String dekita, Model model) {
		
		model.addAttribute("deketa", dekita);
		
		return "myfourthpra";
	}
}