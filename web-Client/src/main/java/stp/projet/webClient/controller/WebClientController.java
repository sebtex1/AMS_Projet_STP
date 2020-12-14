package stp.projet.webClient.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WebClientController {
	
	@GetMapping("/")
	public String getHomePage(Model model) {			
		return "homePage";
	}
}
