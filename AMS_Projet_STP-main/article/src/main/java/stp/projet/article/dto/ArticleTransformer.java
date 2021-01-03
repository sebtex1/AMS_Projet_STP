package stp.projet.article.dto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import stp.projet.article.model.Article;
import stp.projet.article.model.Author;
import stp.projet.article.model.Category;
import stp.projet.article.model.Comment;
import stp.projet.article.repositories.AuthorProxy;
import stp.projet.article.repositories.CategoryProxy;
import stp.projet.article.repositories.CommentProxy;

@Component
public class ArticleTransformer {

	@Autowired
	private AuthorProxy authorProxy;
	
	@Autowired
	private CategoryProxy categoryProxy;
	
	@Autowired
	private CommentProxy commentProxy;
	
	public ArticleR transform(Article a) {
		
		ArticleR articleR = new ArticleR();
		articleR.setId(a.getId());
		articleR.setName(a.getName());
		Category category = categoryProxy.getCategory(a.getIdcategory());
		articleR.setCategory(category);
		Author author = authorProxy.getAuthor(a.getIdauthor());
		articleR.setAuthor(author);
		articleR.setDate(a.getDate());
		articleR.setContent(a.getContent());
		Comment comment = commentProxy.getComment(a.getIdcomments());
		articleR.setComment(comment);
		
		return articleR;
	}
}
