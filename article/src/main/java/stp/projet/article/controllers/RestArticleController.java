package stp.projet.article.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import stp.projet.article.model.Article;
import stp.projet.article.repositories.ArticleRepository;

@RestController
public class RestArticleController {
	
	@Autowired
	private ArticleRepository articleRepository;
	
	@GetMapping("/articles")
	public Iterable<Article> getArticles() {
		Iterable<Article> articles = articleRepository.findAll();
		System.out.println("Sending all articles");
		return articles;
	}

}
