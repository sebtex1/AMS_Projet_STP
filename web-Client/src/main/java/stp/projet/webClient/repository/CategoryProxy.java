package stp.projet.webClient.repository;

import java.util.ArrayList;
import java.util.concurrent.TimeoutException;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.HttpServerErrorException;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

import stp.projet.webClient.model.category;

@Repository
public class CategoryProxy extends GenericProxy{

	public category getCategory(int id) {
		
		String getCategoryUrl = props.getApiUrl() + "/category" + id;
		
		ResponseEntity<category> response = restTemplate.exchange(
				getCategoryUrl, 
				HttpMethod.GET, 
				null, 
				category.class);
		
		return response.getBody();		
	}
	
	@CircuitBreaker(name ="proxy", fallbackMethod = "fallback")
	public Iterable<category> getCategories() {
		
		String getCategoriesUrl = props.getApiUrl() + "/category";
		
		ResponseEntity<Iterable<category>> response = restTemplate.exchange(
				getCategoriesUrl, 
				HttpMethod.GET, 
				null, 
				new ParameterizedTypeReference<Iterable<category>>() {});
		
		return response.getBody();
	}
	
	@SuppressWarnings("unused")
	private Iterable<category> fallback(IllegalStateException ex) {
		System.out.println("From fallback method IllegalState : " + ex.getMessage());
		return new ArrayList<category>();
	}
	
	@SuppressWarnings("unused")
	private Iterable<category> fallback(TimeoutException ex) {
		System.out.println("From fallback method Timeout : " + ex.getMessage());
		return new ArrayList<category>();
	}
	
	@SuppressWarnings("unused")
	private Iterable<category> fallback(HttpServerErrorException ex) {
		System.out.println("From fallback method HttpServerErrorException : " + ex.getMessage());
		return new ArrayList<category>();
	}	
}
