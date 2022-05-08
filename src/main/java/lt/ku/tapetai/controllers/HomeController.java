package lt.ku.tapetai.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {

	@GetMapping("/duom")
	public String home() {
		return "res";
	}
	
//	@PostMapping("/")
//	public String kiekiai(@RequestParam("l_kiekis") Integer l_kiekis, @RequestParam("s_kiekis") Integer s_kiekis, 
//			@RequestParam("d_kiekis") Integer d_kiekis, Model model) {
//		model.addAttribute("s_kiekis", s_kiekis);
//		model.addAttribute("d_kiekis", d_kiekis);
//		model.addAttribute("l_kiekis", l_kiekis);
//		return "res";
//	}
//	
//	@GetMapping("/duom")
//	public String duomenys() {
//		return "res";
//	}
	
	@PostMapping("/duom")
	public String skaiciavimai(@RequestParam("d_ilgis") double d_ilgis, @RequestParam("s_ilgis") double s_ilgis,
			@RequestParam("l_aukstis") double l_aukstis, @RequestParam("s_aukstis") double s_aukstis, 
			@RequestParam("d_aukstis") double d_aukstis, @RequestParam("l_ilgis") double l_ilgis, 
			@RequestParam("l_kiekis") Integer l_kiekis, @RequestParam("s_kiekis") Integer s_kiekis, 
			@RequestParam("d_kiekis") Integer d_kiekis, Model model) {
		model.addAttribute("s_kiekis", s_kiekis);
		model.addAttribute("d_kiekis", d_kiekis);
		model.addAttribute("l_kiekis", l_kiekis);
		model.addAttribute("s_aukstis", s_aukstis);
		model.addAttribute("d_aukstis", d_aukstis);
		model.addAttribute("l_aukstis", l_aukstis);
		model.addAttribute("s_ilgis", s_ilgis);
		model.addAttribute("d_ilgis", d_ilgis);
		model.addAttribute("l_ilgis", l_ilgis);
		
		double s_plotas = (s_ilgis*s_aukstis)*s_kiekis;
		double d_plotas = (d_ilgis*d_aukstis)*d_kiekis;
		double l_plotas = (l_ilgis*l_aukstis)*l_kiekis;
		
		double kiekis = s_plotas-d_plotas-l_plotas;
		
		model.addAttribute("kiekis", kiekis);
		
		return "result";
	}
}
