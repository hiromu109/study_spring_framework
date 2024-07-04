package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MyNinthController {

	//画面を表示するためのGETメソッド
	@RequestMapping(path = "/ninthpage", method = RequestMethod.GET)
	public String ninthget(Model model) {

		String x = "";
		model.addAttribute("datadayo1","A");
		model.addAttribute("datadayo2","B");
		model.addAttribute("datadayo3","C");
		
		List<String> list = new ArrayList<>();
		list.add("リストの中身1個目はぶどう");
		list.add("リストの中身2個目はゴリラ");
		list.add("リストの中身3個目はラッパ");
		
		List<String> list2 = new ArrayList<>();
		list2.add("BA");
		list2.add("NA");
		list2.add("NA");
		
		List<String> list3 = new ArrayList<>();
		list3.add("練習");
		list3.add("問題");
		list3.add("2問目");
		
		model.addAttribute("result",list);
		model.addAttribute("rs2",list2);
		model.addAttribute("pra2",list3);
		
		model.addAttribute("souhuku","問題①");
		
		return "myninth";
	}
	
	//POSTメソッド
	@RequestMapping(path = "/ninthpage", method = RequestMethod.POST)
	public String ninthpost(Model model) {

		return "myninth";
	}
}