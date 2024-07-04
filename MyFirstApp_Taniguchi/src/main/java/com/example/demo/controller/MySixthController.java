package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MySixthController {
	@RequestMapping(path = "/sixthpra", method = RequestMethod.GET)
	public String four() {

		return "MySixth";
	}

	@RequestMapping(path = "/sixthpra", method = RequestMethod.POST)
	public String four(String mem1, String mem2, Model model) {
		System.out.println(mem1 + mem2);
		model.addAttribute("ichimonme", "いちもんめ");

		return "MySixth";
	}

	@RequestMapping(path = "/sixthlogin", method = RequestMethod.GET)
	public String post() {

		return "mysixthlogin";
	}

	@RequestMapping(path = "/sixthlogin", method = RequestMethod.POST)
	public String post(String mem1, String mem2, Model model) {
		System.out.println(mem1 + mem2);
		if ("uho".equals(mem1) && "uhoho".equals(mem2)) {

			model.addAttribute("uu", "ログイン成功");
			return "mysixthloginsuc";
		} else {
			model.addAttribute("uu", "ログイン失敗");
			return "mysixthloginfail";
		}
		
	}

}