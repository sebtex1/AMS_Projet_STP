package stp.projet.webClient.model;

import java.sql.Date;

public class comment {

	private Integer id;
	private Integer idauthor;
	private Date date;
	private String text;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
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
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
}
