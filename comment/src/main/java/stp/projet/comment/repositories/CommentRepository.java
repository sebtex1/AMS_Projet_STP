package stp.projet.comment.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import stp.projet.comment.model.Comment;

@Repository
public interface CommentRepository 
	extends CrudRepository<Comment, Integer>{

}
