package com.autentia.demo.jwt.shoppingcard;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.autentia.demo.jwt.article.ArticleModel;
import com.autentia.demo.jwt.usuario.Usuario;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;



@Entity
@Table(name = "shoping_card_models")
public class ShoppingCardModel {

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(nullable = false)
	private long id;
	

	
	@Column(nullable = false,name = "article_id")
	private long article_id;
	
	@Column(nullable = false,name = "lot")
	private long lot;
	
	@OneToOne
    @JsonBackReference 
    private Usuario user;
	
	@OneToMany(targetEntity = ArticleModel.class, mappedBy = "shoppingCardModel")
    @JsonManagedReference
    private List<ArticleModel> carts;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
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

	

	

	
	
}
