package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MyFifthPraController {

	//画面を表示するためのGETメソッド
	@RequestMapping(path = "/fifthpra", method = RequestMethod.GET)
	public String fourthget(Model model) {
		
		model.addAttribute("modelpra","さんもんめ");
		return "myfifthpra";
	}
	
	//画面を表示するためのGETメソッド
	@RequestMapping(path = "/fifthpra", method = RequestMethod.POST)
	public String fourthpost(String like,Model modelmodel) {
		
		System.out.println(like);
		if(like.equals("お寿司")) {
			like="私もお寿司が好きです。";
		}
		modelmodel.addAttribute("likefood",like);
		return "myfifthpra";
	}
}





