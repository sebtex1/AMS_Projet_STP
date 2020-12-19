package stp.projet.webClient.model;

import java.sql.Date;

public class article {
	
	private Integer id;
	private String name;
	private Integer idcategory;
	private Integer idauthor;
	private Date date;
	private String content;
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
