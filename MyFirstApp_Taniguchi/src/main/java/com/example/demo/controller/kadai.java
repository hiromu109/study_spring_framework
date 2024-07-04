package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class kadai {
	@RequestMapping(path = "/userLogin", method = RequestMethod.GET)
	public String four() {

		return "loginform";
	}

	@RequestMapping(path = "/userLogin", method = RequestMethod.POST)
	public String four(String id, String pass, Model model) {
		int moji = pass.length();
		if ("userlogin".equals(id) && "userpass".equals(pass)) {
			model.addAttribute("uu", id);
			return "home";
		} else if (moji < 8) {
			model.addAttribute("uu", "パスワードが短い");
			return "loginform";
		}else if (!"userlogin".equals(id) && "userpass".equals(pass)) {
			return "loginfalse";
		} else {
			model.addAttribute("uu", "ログイン失敗");
			return "loginform";
		}
	}

	@RequestMapping(path = "/userHome", method = RequestMethod.GET)
	public String post() {

		return "home";
	}

	@RequestMapping(path = "/userHome", method = RequestMethod.POST)
	public String post(String tweet, Model model) {
		model.addAttribute("uu", tweet);
		return "home";
	}

}
