package stp.projet.category.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import stp.projet.category.model.Category;

@Repository
public interface CategoryRepository 
	extends CrudRepository<Category, Integer>{

}
