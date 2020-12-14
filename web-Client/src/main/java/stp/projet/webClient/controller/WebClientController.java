package stp.projet.webClient.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import stp.projet.webClient.model.author;
import stp.projet.webClient.repository.AuthorProxy;


@Controller
public class WebClientController {
	
	@Autowired
	private AuthorProxy authorProxy;
	
	@GetMapping("/")
	public String getHomePage(Model model) {		
		Iterable<author> authors = authorProxy.getAuthors();
		model.addAttribute("authors", authors);		
				
		return "homePage";
	}
}
