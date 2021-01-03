package stp.projet.webClient.model;

import java.sql.Date;

public class article {
	
	private Integer id;
	private String name;
	private category category;
	private author author;
	private Date date;
	private String content;
	private comment comment;
	
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
	public category getCategory() {
		return category;
	}
	public void setCategory(category category) {
		this.category = category;
	}
	public author getAuthor() {
		return author;
	}
	public void setAuthor(author author) {
		this.author = author;
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
	public comment getComment() {
		return comment;
	}
	public void setComment(comment comment) {
		this.comment = comment;
	}	
}
