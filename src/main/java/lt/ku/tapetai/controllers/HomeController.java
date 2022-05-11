package lt.ku.tapetai.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/")
public class HomeController {
	
	@GetMapping("/")
	public String home() {
		return "home";
	}
	
	@PostMapping("/")
	public String homee() {
		return home();
	}

	@GetMapping("/duom")
	public String skaiciavimai() {
		return "res";
	}
	
	@PostMapping("/duom")
	public String skaiciavimai(@RequestParam("d_ilgis") double d_ilgis, @RequestParam("s_ilgis") double s_ilgis,
			@RequestParam("l_aukstis") double l_aukstis, @RequestParam("s_aukstis") double s_aukstis, 
			@RequestParam("d_aukstis") double d_aukstis, @RequestParam("l_ilgis") double l_ilgis, 
			@RequestParam("l_kiekis") Integer l_kiekis, @RequestParam("s_kiekis") Integer s_kiekis, 
			@RequestParam("d_kiekis") Integer d_kiekis, Model model,
			@RequestParam("t_ilgis") double t_ilgis, @RequestParam("t_aukstis") double t_aukstis) {
	
		double s_plotas = (s_ilgis*s_aukstis)*s_kiekis;
		double d_plotas = (d_ilgis*d_aukstis)*d_kiekis;
		double l_plotas = (l_ilgis*l_aukstis)*l_kiekis;
		double kiekis = s_plotas-d_plotas-l_plotas;
		double t_kiekis = kiekis / (t_ilgis*t_aukstis);
		
		model.addAttribute("kiekis", kiekis);
		model.addAttribute("d_plotas", d_plotas);
		model.addAttribute("l_plotas", l_plotas);
		model.addAttribute("t_kiekis", t_kiekis);
		return skaiciavimai();
	}
}
