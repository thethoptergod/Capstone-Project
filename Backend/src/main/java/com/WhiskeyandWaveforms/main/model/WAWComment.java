package com.WhiskeyandWaveforms.main.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="comments")
public class WAWComment {
		@Id
		@GeneratedValue(strategy = GenerationType.SEQUENCE)
		private int id;
		private String name;
		private String email;
		private String comment_text;
	public WAWComment() {}
	public WAWComment(int id, String name, String email, String comment_text) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.comment_text = comment_text;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getComment_text() {
		return comment_text;
	}
	public void setComment_text(String comment_text) {
		this.comment_text = comment_text;
	}
	
}
