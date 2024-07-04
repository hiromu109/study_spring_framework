package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MyFifthCorrectController {

	//画面を表示するためのGETメソッド
	@RequestMapping(path = "/fifthcor", method = RequestMethod.GET)
	public String fourthget() {
		return "myfifthcorrect";
	}
	
	//画面からの値を処理するPOSTメソッド
	@RequestMapping(path = "/fifthcor", method = RequestMethod.POST)
	public String fourthpost(String engineerName,Model model) {
		
		if(engineerName.equals("つよエンジニア")) {
			engineerName="問題なし";
		}else if(engineerName.equals("ひよこエンジニア")) {
			engineerName="もう一度確認";
		}
		model.addAttribute("engineer",engineerName);
		
		return "myfifthcorrect";
	}
}