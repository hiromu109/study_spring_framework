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
public class Sekiyoyaku {

	@Autowired
	JdbcTemplate jdbcTemplate;

	//一覧、登録画面表示用
	@RequestMapping(path = "/sheetreserv", method = RequestMethod.GET)
	public String sheet1(Model model) {

		//検索処理
		List<Map<String, Object>> kensakukekka = jdbcTemplate.queryForList("SELECT * FROM sheetreserve;");

		//検索結果のリストをmodelに格納
		model.addAttribute("kensakupra", kensakukekka);

		return "sheet";
	}

	//編集、削除画面表示用
	@RequestMapping(path = "/reservmodify", method = RequestMethod.GET)
	public String sheet11() {

		/**returnの後ろのhtml名以外は変更の必要無し**/

		return "sheet2";
	}

	//登録用
	@RequestMapping(path = "/sheetIns", method = RequestMethod.POST)
	public String sheet2(String yoyakubango, String yoyakubi, HttpSession session) {

		String name = (String) session.getAttribute("name");

		//登録処理
		jdbcTemplate.update("INSERT INTO sheetreserve (yoyakubango,yoyakubi,yoyakuname) VALUES (?,?,?);", yoyakubango,
				yoyakubi, name);

		return "redirect:/sheetreserv";
	}

	//更新用(ヒント無し)
	@RequestMapping(path = "/sheetUpd", method = RequestMethod.POST)
	public String sheet3(String yoyakubango, HttpSession session) {

		String name = (String) session.getAttribute("name");
		// 更新処理
		jdbcTemplate.update("UPDATE sheetreserve SET yoyakuname=? WHERE yoyakubango =?;", name, yoyakubango);

		return "redirect:/sheetreserv";
	}

	//削除用(ヒント無し)
	@RequestMapping(path = "/sheetDel", method = RequestMethod.POST)
	public String sheet4(String yoyakubango) {

		//削除処理
		jdbcTemplate.update("DELETE FROM sheetreserve WHERE yoyakubango =?;", yoyakubango);

		return "redirect:/sheetreserv";
	}

	//検索用(ヒント無し)
	@RequestMapping(path = "/sheetSer", method = RequestMethod.POST)
	public String sheet5(Model model, String yoyakuname) {

		//検索処理
		String a = "%" + yoyakuname + "%";
		List<Map<String, Object>> kensakukekka = jdbcTemplate
				.queryForList("SELECT * FROM sheetreserve WHERE yoyakuname LIKE ?", a);

		//検索結果のリストをmodelに格納
		model.addAttribute("kensakupra", kensakukekka);

		return "sheet";
	}

}