package stp.projet.author.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
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

}