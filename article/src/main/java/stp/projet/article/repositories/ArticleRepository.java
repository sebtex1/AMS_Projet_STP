package stp.projet.article.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import stp.projet.article.model.Article;

@Repository
public interface ArticleRepository extends CrudRepository<Article, Integer> {

}
