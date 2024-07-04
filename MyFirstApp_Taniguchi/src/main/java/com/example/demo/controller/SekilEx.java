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
public class SekilEx {

	@Autowired
	JdbcTemplate jdbcTemplate;

	@RequestMapping(path = "/reservrank", method = RequestMethod.GET)
	public String sheet13(Model model, HttpSession session) {
		List<Map<String, Object>> kensakukekka = jdbcTemplate
				.queryForList(
						"SELECT yoyakuname FROM(SELECT yoyakuname,count(*) AS COUNT FROM sheetreserve GROUP BY yoyakuname ORDER BY COUNT DESC) AS yoyakuname;");
		for (int i = 0; i < 3; i++) {
			String x = (String) kensakukekka.get(i).get("yoyakuname");
			session.setAttribute("rank" + i, i + 1 + "位");
			session.setAttribute("rankn" + i, x);
		}
		return "sheetrank";
	}

	@RequestMapping(path = "/reservmy", method = RequestMethod.GET)
	public String sheet1(Model model, HttpSession session) {
		String name = (String) session.getAttribute("name");
		//検索処理
		List<Map<String, Object>> kensakukekka = jdbcTemplate
				.queryForList("SELECT * FROM sheetreserve WHERE yoyakuname = ?;", name);

		int count = kensakukekka.size();
		String rank = "";
		if (count == 0) {
			rank = "ひよこユーザー";
		} else if (count >= 1 && count <= 3) {
			rank = "初心者ユーザー";
		} else if (count >= 4 && count <= 7) {
			rank = "ベテランユーザー";
		} else if (count >= 8 && count <= 11) {
			rank = "大御所ユーザー";
		} else {
			rank = "石油王";
		}
		//検索結果のリストをmodelに格納
		model.addAttribute("count", count);
		model.addAttribute("rank", rank);
		model.addAttribute("kensakupra", kensakukekka);
		model.addAttribute("usename", name);
		return "sheetmy";
	}

}