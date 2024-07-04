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
public class MyDbSoloExController {

	@Autowired
	JdbcTemplate jdbcTemplate;

	//画面を表示するためのGETメソッド
	@RequestMapping(path = "/soloex", method = RequestMethod.GET)
	public String dbfg(Model model) {

		//検索処理

		List<Map<String, Object>> kensakukekka = jdbcTemplate.queryForList("SELECT * FROM domeyoyaku");

		//検索結果のリストをmodelに格納
		model.addAttribute("kensakupra", kensakukekka);

		return "mydbsoloex";
	}
	
	@RequestMapping(path = "/soloexSosa", method = RequestMethod.POST)
	public String dbf(Model model,String sosa) {

		
		model.addAttribute("sosa", sosa);
		return "mydbsoloex2";
	}


	@RequestMapping(path = "/soloexIns", method = RequestMethod.POST)
	public String dbfgins(Model model, String yoyakubi, String yoyakuclass, String yoyakuname,String yoyakucoat) {
		List<Map<String, Object>> kensakukekka = jdbcTemplate.queryForList("SELECT * FROM domeyoyaku WHERE yoyakubi=? AND yoyakucoat=?;",yoyakubi,yoyakucoat);
		if(kensakukekka.size()==0) {
			jdbcTemplate.update("INSERT INTO domeyoyaku (yoyakubi,yoyakuclass,yoyakuname,yoyakucoat) VALUES (?,?,?,?);", yoyakubi,
					yoyakuclass, yoyakuname,yoyakucoat);
		}else {
			model.addAttribute("era", "エラー");
		}
		return "redirect:/soloex";
	}


	@RequestMapping(path = "/soloexUpd", method = RequestMethod.POST)
	public String dbfgupd(Model model, String yoyakubi, String yoyakuname, String yoyakubiaf) {

		// データ更新
		jdbcTemplate.update("UPDATE domeyoyaku SET yoyakubi=? WHERE yoyakubi =? AND yoyakuname=?;", yoyakubiaf, yoyakubi,
				yoyakuname);

		return "redirect:/soloex";
	}


	@RequestMapping(path = "/soloexDel", method = RequestMethod.POST)
	public String dbfgdel(Model model, String yoyakubi, String yoyakuname) {

		// データ削除
		jdbcTemplate.update("DELETE FROM domeyoyaku WHERE yoyakubi =? AND yoyakuname=?;", yoyakubi,yoyakuname);

		return "redirect:/soloex";
	}
}
