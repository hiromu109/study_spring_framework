package com.example.demo.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MyDbFourthController {

	@Autowired
	JdbcTemplate jdbcTemplate;

	//画面を表示するためのGETメソッド
	@RequestMapping(path = "/fourthpra", method = RequestMethod.GET)
	public String dbfg(Model model) {

		//検索処理
		List<Map<String, Object>> kensakukekka = jdbcTemplate.queryForList("SELECT * FROM fourthtable");

		//検索結果のリストをmodelに格納
		model.addAttribute("kensakupra", kensakukekka);

		return "mydbfourth";
	}

	/*****データ検索用******/
	@RequestMapping(path = "/fourthpraSer", method = RequestMethod.POST)
	public String dbspuse(Model model, String sername) {

		List<Map<String, Object>> kensakukekka;
		System.out.println(sername);

		if (sername != null) {
			//検索処理
			kensakukekka = jdbcTemplate.queryForList("SELECT * FROM fourthtable WHERE sikakuname = ?", sername);

			//検索結果のリストをmodelに格納する。
			model.addAttribute("kensakupra", kensakukekka);
		}

		return "mydbfourth";
	}

	/*****データ登録用******/
	@RequestMapping(path = "/fourthpraIns", method = RequestMethod.POST)
	public String dbspuin(Model model, String cerrank, String cername) {

		//データ登録
		jdbcTemplate.update("INSERT INTO fourthtable (sikakuname,sikakurank) VALUES (?,?);", cername, cerrank);

		return "redirect:/fourthpra";
	}

	/*****データ更新用******/
	@RequestMapping(path = "/fourthpraUpd", method = RequestMethod.POST)
	public String dbspuup(Model model, String cerrank, String cername) {

		//データ更新
		jdbcTemplate.update("UPDATE fourthtable SET sikakurank=? WHERE sikakuname =?;", cerrank, cername);

		return "redirect:/fourthpra";
	}

	/*****データ削除用******/
	@RequestMapping(path = "/fourthpraDel", method = RequestMethod.POST)
	public String dbspudel(Model model, String cername) {

		//データ削除
		jdbcTemplate.update("DELETE FROM fourthtable WHERE sikakuname = ?;", cername);

		return "redirect:/fourthpra";
	}
}