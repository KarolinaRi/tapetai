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
		return "res2";
	}
	
	@PostMapping("/duom")
	public String skaiciavimai(@RequestParam("s_ilgis1") double s_ilgis1, @RequestParam("s_ilgis2") double s_ilgis2, 
			@RequestParam("s_ilgis3") double s_ilgis3, @RequestParam("s_ilgis4") double s_ilgis4,
			@RequestParam("d_ilgis1") double d_ilgis1, @RequestParam("d_ilgis2") double d_ilgis2, 
			 @RequestParam("l_ilgis1") double l_ilgis1,  @RequestParam("l_ilgis2") double l_ilgis2,
			@RequestParam("l_ilgis3") double l_ilgis3, @RequestParam("l_aukstis1") double l_aukstis1, 
			@RequestParam("l_aukstis2") double l_aukstis2, @RequestParam("l_aukstis3") double l_aukstis3,
			@RequestParam("s_aukstis1") double s_aukstis1, @RequestParam("s_aukstis2") double s_aukstis2,
			@RequestParam("s_aukstis3") double s_aukstis3, @RequestParam("s_aukstis4") double s_aukstis4,
			@RequestParam("d_aukstis1") double d_aukstis1, @RequestParam("d_aukstis2") double d_aukstis2, 
			Model model,
			@RequestParam("t_ilgis") double t_ilgis, @RequestParam("t_aukstis") double t_aukstis) {
	
		double s_plotas = (s_ilgis1*s_aukstis1)+(s_ilgis2*s_aukstis2)+(s_ilgis3*s_aukstis3)+(s_ilgis4*s_aukstis4);
		s_plotas = Math.round(s_plotas*100)/100.00;
		double d_plotas = (d_ilgis1*d_aukstis1)+(d_ilgis2*d_aukstis2);
		d_plotas = Math.round(d_plotas*100)/100.00;
		double l_plotas = (l_ilgis1*l_aukstis1)+(l_ilgis2*l_aukstis2)+(l_ilgis3*l_aukstis3);
		l_plotas = Math.round(l_plotas*100)/100.00;
		double kiekis = s_plotas-d_plotas-l_plotas;
		kiekis = Math.round(kiekis*100)/100.00;
		double t_kiekis = kiekis / (t_ilgis*t_aukstis);
		t_kiekis=Math.round(t_kiekis*100)/100.0;
		
		model.addAttribute("kiekis", kiekis);
		model.addAttribute("d_plotas", d_plotas);
		model.addAttribute("l_plotas", l_plotas);
		model.addAttribute("t_kiekis", t_kiekis);
		return skaiciavimai();
	}
}