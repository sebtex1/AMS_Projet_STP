package stp.projet.article.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import stp.projet.article.model.Comment;

@Repository
public class CommentProxy {

	@Autowired
	public RestTemplate restTemplate;
	
	private String apiUrl = "localhost:9103";
	
	public Comment getComment(Integer id)  {
		
		String getCommentUrl = apiUrl + "/comment/" + id;
		
		//RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<Comment> response = restTemplate.exchange(getCommentUrl, HttpMethod.GET, null, Comment.class);
		
		return response.getBody();
	}
}
