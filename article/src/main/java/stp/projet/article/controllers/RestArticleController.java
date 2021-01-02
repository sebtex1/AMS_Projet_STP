package stp.projet.article.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import stp.projet.article.dto.ArticleR;
import stp.projet.article.service.ArticleService;

@RestController
public class RestArticleController {
	
	@Autowired
	private ArticleService articleService;
	
	@GetMapping("/article")
	public Iterable<ArticleR> getArticles() {
		
		return articleService.getArticles();
	}
	
	@GetMapping("/article/{id}")
	public ArticleR getArticle(@PathVariable("id") int id) {
			
		return articleService.getArticle(id);		
	}

}
