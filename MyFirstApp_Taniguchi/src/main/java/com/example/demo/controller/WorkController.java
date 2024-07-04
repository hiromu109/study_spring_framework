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
public class WorkController {
	@Autowired
	JdbcTemplate jdbcTemplate;
	@RequestMapping(path = "/classupd", method = RequestMethod.GET)
	public String dbfg(Model model) {

		//検索処理

		List<Map<String, Object>> kensakukekka = jdbcTemplate.queryForList("SELECT * FROM m_user");

		//検索結果のリストをmodelに格納
		model.addAttribute("kensakupra", kensakukekka);

		return "work";
	}

	@RequestMapping(path = "/classupd", method = RequestMethod.POST)
	public String dbfg(Model model, String bef, String aft,HttpSession session) {
		boolean aa = aft.contains("A");
		boolean bb = aft.contains("B");
		boolean cc = aft.contains("C");
		boolean dd = aft.contains("D");
		boolean ee = aft.contains("E");
		boolean ff = aft.contains("F");
		boolean gg = aft.contains("G");
		boolean hh = aft.contains("H");
		boolean ii = aft.contains("I");
		boolean jj = aft.contains("J");
		boolean kk = aft.contains("K");

		if (aa || bb || cc || dd || ee || ff || gg || hh || ii || jj || kk == true||aft.equals(aft)) {
			jdbcTemplate.update("UPDATE m_user SET class=? WHERE class =? ;", aft, bef);
			session.setAttribute("out", "sef");
			System.out.println("a");
		}else {
			session.setAttribute("out", "outt");
			System.out.println("b");
		}

		return "redirect:/classupd";
	}
	@RequestMapping(path = "/classser", method = RequestMethod.POST)
	public String dbspuse(Model model,String ser,HttpSession session) {

		
		session.setAttribute("out", "sef");
		List<Map<String,Object>> kensakukekka;
		System.out.println(ser);
		
		if(ser != null) {
			//検索処理
			kensakukekka = jdbcTemplate.queryForList("SELECT * FROM m_user WHERE class = ?",ser);

			//検索結果のリストをmodelに格納する。
			model.addAttribute("kensakupra",kensakukekka);
		} 	

		return "work";
	}

}
