package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jakarta.servlet.http.HttpSession;

@Controller
public class seckadai {
	@RequestMapping(path = "/zasekiyoyaku", method = RequestMethod.GET)
	public String four() {

		return "kadaihome";
	}

	@RequestMapping(path = "/zasekiyoyaku", method = RequestMethod.POST)
	public String four(String sosa, String num, String mato1, String mato2, String kesu, String tuki, Model model,
			HttpSession session) {
		model.addAttribute("sosa", sosa);

		int[] numlist = new int[10];

		if (num != null) {
			int numm = Integer.parseInt(num);
			for (int i = 0; i < 10; i++) {
				if (i + 1 == numm) {
					System.out.println(numlist[i]);
					if (session.getAttribute("a" + i) == null) {
						numlist[i] = numm;
						session.setAttribute("a" + i, numlist[i] + "番" + "  " + tuki);
					} else {
						model.addAttribute("kabu", "kaburi");
					}
				}

			}
		}
		if (mato1 != null && mato2 != null) {
			int numm = Integer.parseInt(mato1);
			int numn = Integer.parseInt(mato2);
			if (numm < numn) {
				for (int b = numm; b <= numn; b++) {
					for (int i = 0; i < 10; i++) {
						if (i + 1 == b) {
							numlist[i] = b;
							session.setAttribute("a" + i, numlist[i] + "番");
						}
					}
				}
			} else {
				for (int b = numn; b <= numm; b++) {
					for (int i = 0; i < 10; i++) {
						if (i + 1 == b) {
							numlist[i] = b;
							session.setAttribute("a" + i, numlist[i] + "番");
						}
					}
				}
			}
		}
		if (kesu != null) {
			int numm = Integer.parseInt(kesu);
			for (int i = 0; i < 10; i++) {
				if (i + 1 == numm) {
					session.setAttribute("a" + i, null);
				}
			}
		}
		return "kadaihome";
	}

	@RequestMapping(path = "/removesession", method = RequestMethod.GET)
	public String rem(HttpSession session) {

		session.removeAttribute("a0");
		session.removeAttribute("a1");
		session.removeAttribute("a2");
		session.removeAttribute("a3");
		session.removeAttribute("a4");
		session.removeAttribute("a5");
		session.removeAttribute("a6");
		session.removeAttribute("a7");
		session.removeAttribute("a8");
		session.removeAttribute("a9");

		return "kadaihome";
	}
}
