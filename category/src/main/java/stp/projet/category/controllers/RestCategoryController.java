package stp.projet.category.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
	
	@PostMapping("/category")
	public Category createCategory(@RequestBody Category category) {
		category = categoryRepository.save(category);
		return category;
	}
	
	@DeleteMapping("/category/{id}")
	public void deleteCategory(@PathVariable("id") Integer id) {
		categoryRepository.deleteById(id);
	}
	
	@PutMapping("/category/{id}")
	public Category updateCategory(@PathVariable("id") Integer id, @RequestBody Category category) {
		Category  currentCategory  = categoryRepository.findById(id).get();
		
		String name = category.getName();
		if(name != null) {
			currentCategory.setName(name);
		}
		
		currentCategory = categoryRepository.save(currentCategory);
		return currentCategory;
	}
}
