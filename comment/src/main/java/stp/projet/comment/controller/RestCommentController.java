package stp.projet.comment.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import stp.projet.comment.model.Comment;
import stp.projet.comment.repositories.CommentRepository;

@RestController
public class RestCommentController {
	
	@Autowired
	private CommentRepository commentRepository;
	
	@GetMapping("/comment")
	public Iterable<Comment> getComment() {
		Iterable<Comment> comment = commentRepository.findAll();	
		System.out.println("sending all comment");
		return comment;
	}

}