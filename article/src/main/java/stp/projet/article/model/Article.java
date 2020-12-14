package stp.projet.article.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "articles")
public class Article {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private Integer id;
	
	@Column(name ="name")
	private String name;
	
	@Column(name ="idcategory")
	private Integer idcategory;
	
	@Column(name ="idauthor")
	private Integer idauthor;
	
	@Column(name ="date")
	private Date date;
	
	@Column(name ="content")
	private String content;
	
	@Column(name ="idcomments")
	private Integer idcomments;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getIdcategory() {
		return idcategory;
	}

	public void setIdcategory(Integer idcategory) {
		this.idcategory = idcategory;
	}

	public Integer getIdauthor() {
		return idauthor;
	}

	public void setIdauthor(Integer idauthor) {
		this.idauthor = idauthor;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Integer getIdcomments() {
		return idcomments;
	}

	public void setIdcomments(Integer idcomments) {
		this.idcomments = idcomments;
	}
	
	
}
