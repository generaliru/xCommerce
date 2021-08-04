package com.autentia.demo.jwt.shoppingcard;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.autentia.demo.jwt.article.ArticleModel;
import com.autentia.demo.jwt.usuario.Usuario;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;



@Entity
@Table(name = "shoping_card")
public class ShoppingCardModel {

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(nullable = false)
	private long id;
	
	@Column(nullable = false,name = "lot")
	private long lot;
	
	@JsonProperty(access = Access.WRITE_ONLY)
	@ManyToOne
	private Usuario user;
	
	@ManyToOne
	private ArticleModel article;

	/**
	 * @return the id
	 */
	public long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(long id) {
		this.id = id;
	}

	/**
	 * @return the lot
	 */
	public long getLot() {
		return lot;
	}

	/**
	 * @param lot the lot to set
	 */
	public void setLot(long lot) {
		this.lot = lot;
	}

	/**
	 * @return the user
	 */
	public Usuario getUser() {
		return user;
	}

	/**
	 * @param user the user to set
	 */
	public void setUser(Usuario user) {
		this.user = user;
	}

	/**
	 * @return the article
	 */
	public ArticleModel getArticle() {
		return article;
	}

	/**
	 * @param article the article to set
	 */
	public void setArticle(ArticleModel article) {
		this.article = article;
	}
	
}
