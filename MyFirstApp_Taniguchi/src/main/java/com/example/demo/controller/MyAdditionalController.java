package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MyAdditionalController {
	@RequestMapping(path = "/additional", method = RequestMethod.GET)
	public String four() {

		return "myadditional";
	}

	@RequestMapping(path = "/additional", method = RequestMethod.POST)
	public String four(String q1, String q2, String q3, String q4, Model model) {
		String keka = q1 + q2 + q3 + q4;
		if (keka.equals("istj")) {
			model.addAttribute("name", "ISTJ");
			model.addAttribute("type", "「義務遂行者」");
			model.addAttribute("tokucho", "実用的で真面目、事実に基づいて行動する。組織と責任を重んじる。");
			return "myadditional";
		} else if (keka.equals("isfj")) {
			model.addAttribute("name", "ISFJ");
			model.addAttribute("type", "「保護者」");
			model.addAttribute("tokucho", "温かく、寛大、忠実。伝統と安定性を大切にする");
			return "myadditional";
		} else if (keka.equals("infj")) {
			model.addAttribute("name", "INFJ");
			model.addAttribute("type", "「カウンセラー」");
			model.addAttribute("tokucho", "洞察力があり、直感的。理想主義的で、他人の成長を助けることに情熱を持つ。");
			return "myadditional";
		} else if (keka.equals("intj")) {
			model.addAttribute("name", "INTJ");
			model.addAttribute("type", "「戦略家」");
			model.addAttribute("tokucho", "独立心が強く、創造的。複雑な問題解決に優れている");
			return "myadditional";
		} else if (keka.equals("istp")) {
			model.addAttribute("name", "ISTP");
			model.addAttribute("type", "「職人」");
			model.addAttribute("tokucho", "現実的で柔軟、効率的。危機管理能力が高い。");
			return "myadditional";
		} else if (keka.equals("isfp")) {
			model.addAttribute("name", "ISFP");
			model.addAttribute("type", "「アーティスト」");
			model.addAttribute("tokucho", "穏やかで忍耐強い。現在を生きることを楽しむ。");
			return "myadditional";
		} else if (keka.equals("infp")) {
			model.addAttribute("name", "INFP");
			model.addAttribute("type", "「仲介者」");
			model.addAttribute("tokucho", "内省的で理想主義的。創造的で情熱的。");
			return "myadditional";
		} else if (keka.equals("intp")) {
			model.addAttribute("name", "INTP");
			model.addAttribute("type", "「論理学者」");
			model.addAttribute("tokucho", "非常に知的で理論的。好奇心旺盛で独創的。");
			return "myadditional";
		} else if (keka.equals("estp")) {
			model.addAttribute("name", "ESTP");
			model.addAttribute("type", "「冒険家」");
			model.addAttribute("tokucho", "行動的でエネルギッシュ。現実的で解決志向。");
			return "myadditional";
		} else if (keka.equals("esfp")) {
			model.addAttribute("name", "ESFP");
			model.addAttribute("type", "「パフォーマー」");
			model.addAttribute("tokucho", "社交的で活発。楽しいことを見つけ、共有するのが得意。");
			return "myadditional";
		} else if (keka.equals("enfp")) {
			model.addAttribute("name", "ENFP");
			model.addAttribute("type", "「活動家」");
			model.addAttribute("tokucho", "熱意があり、創造的。可能性を見つけて刺激する。");
			return "myadditional";
		} else if (keka.equals("entp")) {
			model.addAttribute("name", "ENTP");
			model.addAttribute("type", "「発明家」");
			model.addAttribute("tokucho", "知的で好奇心が強い。新しいことに挑戦するのが好き。");
			return "myadditional";
		} else if (keka.equals("estj")) {
			model.addAttribute("name", "ESTJ");
			model.addAttribute("type", "「実行者」");
			model.addAttribute("tokucho", "組織的で実践的。リーダーシップがあり、物事を成し遂げる。");
			return "myadditional";
		} else if (keka.equals("esfj")) {
			model.addAttribute("name", "ESFJ");
			model.addAttribute("type", "「提供者」");
			model.addAttribute("tokucho", "協力的で調和を重んじる。他人のニーズに敏感。");
			return "myadditional";
		} else if (keka.equals("enfj")) {
			model.addAttribute("name", "ENFJ");
			model.addAttribute("type", "「教師」");
			model.addAttribute("tokucho", "社交的でカリスマ的。他人を奮い立たせ、導く。");
			return "myadditional";
		} else if (keka.equals("entj")) {
			model.addAttribute("name", "ENTJ");
			model.addAttribute("type", "「指導者」");
			model.addAttribute("tokucho", "決断力があり、自信がある。挑戦を楽しみ、目標を達成する。");
			return "myadditional";
		}
		return "myadditional";
	}

}
