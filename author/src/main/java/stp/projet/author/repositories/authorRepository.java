package stp.projet.author.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import stp.projet.author.model.author;

@Repository
public interface authorRepository 
	extends CrudRepository<author, Integer>{

}
