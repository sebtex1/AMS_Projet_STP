package stp.projet.comment.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import stp.projet.comment.model.Comment;
import stp.projet.comment.repositories.CommentRepository;

@RestController
public class RestCommentController {
	
	@Autowired
	private CommentRepository commentRepository;
	
	@GetMapping("/comment")
	public Iterable<Comment> getComments() {
		Iterable<Comment> comments = commentRepository.findAll();	
		System.out.println("sending all comment");
		return comments;
	}

	@GetMapping("/comment/{id}")
	public Optional<Comment> getComment(@PathVariable("id") int id) 
			throws InterruptedException {
		Optional<Comment> comment = commentRepository.findById(id);		
		System.out.println("Retrieve " + comment.get().getId());
		return comment;		
	}
	
	@PostMapping("/comment")
	public Comment createAuthor(@RequestBody Comment comment) {
		comment = commentRepository.save(comment);
		return comment;
	}
	
	@DeleteMapping("/comment/{id}")
	public void deleteComment(@PathVariable("id") Integer id) {
		commentRepository.deleteById(id);
	}
	
	@PutMapping("/comment/{id}")
	public Comment updateComment(@PathVariable("id") Integer id, @RequestBody Comment comment) {
		Comment  currentComment  = commentRepository.findById(id).get();
		
		String text = comment.getText();
		if(text != null) {
			currentComment.setText(text);
		}
		
		currentComment = commentRepository.save(currentComment);
		return currentComment;
	}
}