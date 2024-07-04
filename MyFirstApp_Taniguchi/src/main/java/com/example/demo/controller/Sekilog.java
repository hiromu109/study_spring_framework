package com.example.demo.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jakarta.servlet.http.HttpSession;

@Controller
public class Sekilog {

	@Autowired
	JdbcTemplate jdbcTemplate;

	//一覧、登録画面表示用
	@RequestMapping(path = "/sheetLog", method = RequestMethod.GET)
	public String sheet1(Model model) {
		return "sekilog";
	}

	//検索用(ヒント無し)
	@RequestMapping(path = "/sheetLog", method = RequestMethod.POST)
	public String sheet5(Model model, String userid, String userpass,HttpSession session) {

		//検索処理
		List<Map<String, Object>> kensakukekka = jdbcTemplate
				.queryForList("SELECT * FROM sheetuser WHERE userid =?AND userpass=? ", userid, userpass);
		if(kensakukekka.size()==1) {
			session.setAttribute("name", userid);
			return "redirect:/sheetreserv";			
		}else {
			return "sekilog";			
		}

	}

}