package stp.projet.article.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import stp.projet.article.model.Article;
import stp.projet.article.repositories.ArticleRepository;

@RestController
public class RestArticleController {
	
	@Autowired
	private ArticleRepository articleRepository;
	
	@GetMapping("/article")
	public Iterable<Article> getArticles() {
		Iterable<Article> articles = articleRepository.findAll();
		System.out.println("Sending all articles");
		return articles;
	}
	
	@GetMapping("/article/{id}")
	public Optional<Article> getAuthor(@PathVariable("id") int id) 
			throws InterruptedException {
		Optional<Article> article = articleRepository.findById(id);		
		System.out.println("Retrieve " + article.get().getName());
		return article;		
	}

}
