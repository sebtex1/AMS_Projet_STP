package stp.projet.webClient.repository;

import java.util.ArrayList;
import java.util.concurrent.TimeoutException;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.HttpServerErrorException;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

import stp.projet.webClient.model.author;

@Repository
public class AuthorProxy extends GenericProxy {

	public author getAuthor(int id) {
		
		String getAuthorUrl = props.getApiUrl() + "/author/" + id;
		
		ResponseEntity<author> response = restTemplate.exchange(
				getAuthorUrl, 
				HttpMethod.GET, 
				null, 
				author.class);
		
		return response.getBody();		
	}
	
	@CircuitBreaker(name ="proxy", fallbackMethod = "fallback")
	public Iterable<author> getAuthors() {
		
		String getAuthorsUrl = props.getApiUrl() + "/author";
		
		ResponseEntity<Iterable<author>> response = restTemplate.exchange(
				getAuthorsUrl, 
				HttpMethod.GET, 
				null, 
				new ParameterizedTypeReference<Iterable<author>>() {});
		
		return response.getBody();
	}
	
	@SuppressWarnings("unused")
	private Iterable<author> fallback(IllegalStateException ex) {
		System.out.println("From fallback method IllegalState : " + ex.getMessage());
		return new ArrayList<author>();
	}
	
	@SuppressWarnings("unused")
	private Iterable<author> fallback(TimeoutException ex) {
		System.out.println("From fallback method Timeout : " + ex.getMessage());
		return new ArrayList<author>();
	}
	
	@SuppressWarnings("unused")
	private Iterable<author> fallback(HttpServerErrorException ex) {
		System.out.println("From fallback method HttpServerErrorException : " + ex.getMessage());
		return new ArrayList<author>();
	}
	
	public author createAuthor(author author) {
		
		String createAuthorUrl = props.getApiUrl() + "/author";
		
		HttpEntity<author> requestEntity = new HttpEntity<author>(author);
		ResponseEntity<author> response = restTemplate.exchange(
				createAuthorUrl,
				HttpMethod.POST,
				requestEntity,
				author.class);
		
		return response.getBody();
		
	}

}
