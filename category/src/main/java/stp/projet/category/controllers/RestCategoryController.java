package stp.projet.category.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import stp.projet.category.model.Category;
import stp.projet.category.repositories.CategoryRepository;

@RestController
public class RestCategoryController {
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	@GetMapping("/category")
	public Iterable<Category> getCategories() {
		Iterable<Category> categories = categoryRepository.findAll();	
		System.out.println("sending all categories");
		return categories;
	}
	
	@GetMapping("/category/{id}")
	public Optional<Category> getCategory(@PathVariable("id") int id) 
			throws InterruptedException {
		Optional<Category> category = categoryRepository.findById(id);		
		System.out.println("Retrieve " + category.get().getName());
		return category;		
	}
}
