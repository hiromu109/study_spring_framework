package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jakarta.servlet.http.HttpSession;

@Controller
public class MyTwelvethController {

	@RequestMapping(path = "/twelvethpage", method = RequestMethod.GET)
	public String twelvethget(Model model,HttpSession session) {
		
		model.addAttribute("modelData", "モデルだよ～");
		session.setAttribute("sessionData", "セッションにしまったよ");
		
		List<String> list = new ArrayList<String>();
		list.add("1件目：田中 太郎");
		list.add("2件目：山本");
		list.add("3件目：たかはし");
		
		model.addAttribute("resultList", list);
		
		return "mytwelveth";
	}
	
	@RequestMapping(path = "/twelvethpage", method = RequestMethod.POST)
	public String twelvethpost(Model model) {
		
		
		return "mytwelveth";

	}
	@RequestMapping(path = "/tweone", method = RequestMethod.GET)
	public String twelvethone(Model model) {
		model.addAttribute("modelPra1", "練習問題①");
		
		List<String> pralist = new ArrayList<String>();
		pralist.add("1件目だよ");
		pralist.add("2件目だよ");
		pralist.add("3件目だよ");
		pralist.add("4件目だよ");
		
		model.addAttribute("listpra", pralist);
		
		return "mytwelveth";

	}
	@RequestMapping(path = "/twefour", method = RequestMethod.POST)
	public String tweft(Model model) {
		
		
		return "mytwelveth";

	}
}