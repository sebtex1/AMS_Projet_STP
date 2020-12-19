package stp.projet.webClient.repository;

import java.util.ArrayList;
import java.util.concurrent.TimeoutException;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.HttpServerErrorException;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

import stp.projet.webClient.model.comment;

@Repository
public class CommentProxy extends GenericProxy {

	public comment getComment(int id) {
		
		String getCommentUrl = props.getApiUrl() + "/comment" + id;
		
		ResponseEntity<comment> response = restTemplate.exchange(
				getCommentUrl, 
				HttpMethod.GET, 
				null, 
				comment.class);
		
		return response.getBody();		
	}
	
	@CircuitBreaker(name ="proxy", fallbackMethod = "fallback")
	public Iterable<comment> getComments() {
		
		String getCommentsUrl = props.getApiUrl() + "/comment";
		
		ResponseEntity<Iterable<comment>> response = restTemplate.exchange(
				getCommentsUrl, 
				HttpMethod.GET, 
				null, 
				new ParameterizedTypeReference<Iterable<comment>>() {});
		
		return response.getBody();
	}
	
	@SuppressWarnings("unused")
	private Iterable<comment> fallback(IllegalStateException ex) {
		System.out.println("From fallback method IllegalState : " + ex.getMessage());
		return new ArrayList<comment>();
	}
	
	@SuppressWarnings("unused")
	private Iterable<comment> fallback(TimeoutException ex) {
		System.out.println("From fallback method Timeout : " + ex.getMessage());
		return new ArrayList<comment>();
	}
	
	@SuppressWarnings("unused")
	private Iterable<comment> fallback(HttpServerErrorException ex) {
		System.out.println("From fallback method HttpServerErrorException : " + ex.getMessage());
		return new ArrayList<comment>();
	}	
}
