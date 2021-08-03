package com.autentia.demo.jwt.shoppingcard;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.OneToOne;

import com.autentia.demo.jwt.usuario.Usuario;
import com.fasterxml.jackson.annotation.JsonBackReference;




public class ShoppingCardModel {

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(nullable = false)
	private long id;
	
	@Column(nullable = false,name = "user_id")
	private long user_id;
	
	@Column(nullable = false,name = "article_id")
	private long article_id;
	
	@Column(nullable = false,name = "lot")
	private long lot;
	
	//Creo una relacion de 1 a muchos, pongo el nombre de mi clase al que se hace relacion
	//mappedby se ocupa para decir que es una relacion bidireccional
	@OneToOne(targetEntity = Usuario.class, mappedBy = "id")
	@JsonBackReference 
	private Usuario user;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getUser_id() {
		return user_id;
	}

	public void setUser_id(long user_id) {
		this.user_id = user_id;
	}

	public long getArticle_id() {
		return article_id;
	}

	public void setArticle_id(long article_id) {
		this.article_id = article_id;
	}

	public long getLot() {
		return lot;
	}

	public void setLot(long lot) {
		this.lot = lot;
	}

	public Usuario getUser() {
		return user;
	}

	public void setUser(Usuario user) {
		this.user = user;
	}
	
	

	

	
	
}
