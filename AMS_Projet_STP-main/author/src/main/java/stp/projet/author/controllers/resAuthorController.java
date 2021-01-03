package stp.projet.author.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import stp.projet.author.model.author;
import stp.projet.author.repositories.authorRepository;

@RestController
public class resAuthorController {
	
	@Autowired
	private authorRepository authorRepository;
	
	@GetMapping("/author")
	public Iterable<author> getAuthor(){
		
		Iterable<author> authors = authorRepository.findAll();	
		System.out.println("sending all authors");
		return authors;

	}
	
	@GetMapping("/author/{id}")
	public Optional<author> getAuthor(@PathVariable("id") int id) 
			throws InterruptedException {
		Optional<author> author = authorRepository.findById(id);		
		System.out.println("Retrieve " + author.get().getName());
		return author;		
	}
	
	@PostMapping("/authors")
	public author createAuthor(@RequestBody author author) {
		author = authorRepository.save(author);
		return author;
	}
	

}