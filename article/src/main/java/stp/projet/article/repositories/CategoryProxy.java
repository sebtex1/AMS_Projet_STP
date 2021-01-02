package stp.projet.article.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import stp.projet.article.model.Category;

@Repository
public class CategoryProxy {

	@Autowired
	public RestTemplate restTemplate;
	
	private String apiUrl = "localhost:9103";
	
	public Category getCategory(Integer id) {
		
		String getCategoryUrl = apiUrl + "/category/" + id;
		
		//RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<Category> response = restTemplate.exchange(getCategoryUrl, HttpMethod.GET, null, Category.class);
		
		return response.getBody();
	}
}
