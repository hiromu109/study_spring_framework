package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MySecondController {

	@RequestMapping(path = "/secondpagepara", method = RequestMethod.GET)
	public String second() {
		return "mysecond";
	}
	@RequestMapping(path = "/secondpagepara/chall", method = RequestMethod.GET)
	public String secondchall() {
		return "mysecondchall";
	}
}