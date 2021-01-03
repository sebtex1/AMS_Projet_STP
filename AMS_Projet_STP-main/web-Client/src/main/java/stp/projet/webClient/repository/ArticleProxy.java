package stp.projet.webClient.repository;

import java.util.ArrayList;
import java.util.concurrent.TimeoutException;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.HttpServerErrorException;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

import stp.projet.webClient.model.article;

@Repository
public class ArticleProxy extends GenericProxy {
	
	public article getArticle(int id) {
		
		String getArticleUrl = props.getApiUrl() + "/article/" + id;
		
		ResponseEntity<article> response = restTemplate.exchange(
				getArticleUrl, 
				HttpMethod.GET, 
				null, 
				article.class);
		
		return response.getBody();		
	}
	
	@CircuitBreaker(name ="proxy", fallbackMethod = "fallback")
	public Iterable<article> getArticles() {
		
		String getArticlesUrl = props.getApiUrl() + "/article";
		
		ResponseEntity<Iterable<article>> response = restTemplate.exchange(
				getArticlesUrl, 
				HttpMethod.GET, 
				null, 
				new ParameterizedTypeReference<Iterable<article>>() {});
		
		return response.getBody();
	}
	
	@SuppressWarnings("unused")
	private Iterable<article> fallback(IllegalStateException ex) {
		System.out.println("From fallback method IllegalState : " + ex.getMessage());
		return new ArrayList<article>();
	}
	
	@SuppressWarnings("unused")
	private Iterable<article> fallback(TimeoutException ex) {
		System.out.println("From fallback method Timeout : " + ex.getMessage());
		return new ArrayList<article>();
	}
	
	@SuppressWarnings("unused")
	private Iterable<article> fallback(HttpServerErrorException ex) {
		System.out.println("From fallback method HttpServerErrorException : " + ex.getMessage());
		return new ArrayList<article>();
	}

}
