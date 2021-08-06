package com.autentia.demo.jwt.shoppingcard;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
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
	
	@OneToOne
    @JoinColumn(name = "FK_usuario", updatable = false, nullable = false)
	private Usuario usuario;
	
	@ManyToMany(mappedBy = "shoppingCard")
	private List<ArticleModel> article;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getLot() {
		return lot;
	}

	public void setLot(long lot) {
		this.lot = lot;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public List<ArticleModel> getArticle() {
		return article;
	}

	public void setArticle(List<ArticleModel> article) {
		this.article = article;
	}

	
	
}
