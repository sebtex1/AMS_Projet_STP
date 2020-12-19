package stp.projet.webClient.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import stp.projet.webClient.model.author;
import stp.projet.webClient.model.article;
import stp.projet.webClient.model.category;
import stp.projet.webClient.model.comment;
import stp.projet.webClient.repository.AuthorProxy;
import stp.projet.webClient.repository.ArticleProxy;
import stp.projet.webClient.repository.CategoryProxy;
import stp.projet.webClient.repository.CommentProxy;

@Controller
public class WebClientController {
	
	@Autowired
	private AuthorProxy authorProxy;
	
	@Autowired
	private ArticleProxy articleProxy;
	
	@Autowired
	private CategoryProxy categoryProxy;
	
	@Autowired
	private CommentProxy commentProxy;
	
	@GetMapping("/")
	public String getHomePage(Model model) {		
		Iterable<author> authors = authorProxy.getAuthors();
		model.addAttribute("authors", authors);		
		
		Iterable<article> articles = articleProxy.getArticles();
		model.addAttribute("articles", articles);
		
		Iterable<category> categories = categoryProxy.getCategories();
		model.addAttribute("categories", categories);
		
		Iterable<comment> comments = commentProxy.getComments();
		model.addAttribute("comments", comments);
		return "homePage";
	}
}
