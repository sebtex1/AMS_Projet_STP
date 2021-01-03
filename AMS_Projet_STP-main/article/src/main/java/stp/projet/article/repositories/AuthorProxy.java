package stp.projet.article.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import stp.projet.article.model.Author;

@Repository
public class AuthorProxy {
	
	@Autowired
	public RestTemplate restTemplate;
	
	private String apiUrl = "localhost:9103";
	
	public Author getAuthor(Integer id) {
		
		String getAuthorUrl = apiUrl + "/author/" + id;
		
		//RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<Author> response = restTemplate.exchange(getAuthorUrl, HttpMethod.GET, null, Author.class);
		
		return response.getBody();
	}

}
