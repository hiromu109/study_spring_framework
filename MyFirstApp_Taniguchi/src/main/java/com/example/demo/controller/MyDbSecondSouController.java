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
public class MyDbSecondSouController {

	@Autowired
	JdbcTemplate jdbcTemplate;

	//画面を表示するためのGETメソッド
	@RequestMapping(path = "/mydbsecondsou", method = RequestMethod.GET)
	public String dbsg2(Model model) {


		
		//検索処理(secondtable用)
		List<Map<String,Object>> kensakukekkaSecond;
		kensakukekkaSecond = jdbcTemplate.queryForList("SELECT * FROM secondsoutable");

		
		//検索結果のリストをmodelに格納
		model.addAttribute("kensakupraSecond",kensakukekkaSecond);

		return "mydbsecondsou";
	}
	
	/**************************↓今日重要なのはここから↓******************************/
	@RequestMapping(path = "/mydbsecondsou", method = RequestMethod.POST)
	public String dbfgpra(Model model,String searchGai,String searchWordEn) {

		List<Map<String,Object>> kensakukekka;
		System.out.println(searchGai);
		
		if(searchGai != null) {
			//検索処理
			kensakukekka = jdbcTemplate.queryForList("SELECT * FROM secondsoutable WHERE gaiyo = ?",searchGai);

			//検索結果のリストをmodelに格納する。
			model.addAttribute("kensakupraSecond",kensakukekka);
		} 	

		return "mydbsecondsou";
	}
	
	
	@RequestMapping(path = "/mydbsecondsouIns", method = RequestMethod.POST)
	public String dbspins(Model model,String inputGai,String inputSetu) {

		
		//データ登録
		jdbcTemplate.update("INSERT INTO secondsoutable (gaiyo,setumei) VALUES (?,?);",inputGai,inputSetu);
		
		//データ登録後、全件検索
		List<Map<String,Object>> kensakukekka;
		kensakukekka = jdbcTemplate.queryForList("SELECT * FROM secondsoutable");
		//検索結果のリストをmodelに格納する。
		model.addAttribute("kensakupraSecond",kensakukekka);		

		return "mydbsecondsou";
	}
	/**************************************************************************/
	
}