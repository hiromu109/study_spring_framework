package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MyFourthController {

	//画面を表示するためのGETメソッド
	@RequestMapping(path = "/fourthpage", method = RequestMethod.GET)
	public String fourthget() {
		return "myfourth";
	}
	
	//画面からの値を処理するPOSTメソッド
	@RequestMapping(path = "/fourthpage", method = RequestMethod.POST)
	public String fourthpost(String param1,String param2,String bplace, Model model) {
		
		System.out.println("画面から"+ param1 +"と入力されました。趣味は"+param2+"のようです。出身は"+bplace+"です。");
		
		model.addAttribute("userName", param1);
		model.addAttribute("umare", bplace);
		
		return "myfourth";
	}
}