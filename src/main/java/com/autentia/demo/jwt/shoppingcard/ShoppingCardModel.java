package com.autentia.demo.jwt.shoppingcard;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.autentia.demo.jwt.article.ArticleModel;
import com.autentia.demo.jwt.usuario.Usuario;
import com.fasterxml.jackson.annotation.JsonManagedReference;
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
	
	/**
	 * Allow manage the reference between ShoppingCard and User, only card can see
	 * the information of user of relationship and respect the logic of foreign key
	 * and indicates that column is referenced. This last reference can´t be null never!
	 * */
	@OneToOne
	@JsonManagedReference
    @JoinColumn(name = "fk_usuario", updatable = false, nullable = false)
	private Usuario usuario;
	
	
	/**
	 * Allow create a intermediate table that includes a Foreign key of ShoppingCart
	 * and a Foreign key of Article in a relationship ManyToMany between this tables.
	 * 
	 * This intermediate table have a name "rel_shoppingCards_Articles" that have a
	 * primary key conformed by both Foreign key's
	 * */
	@JoinTable(
	        name = "rel_shoppingCards_Articles",
	        joinColumns = @JoinColumn(name = "FK_SHOPPINGCARD"),
	        inverseJoinColumns = @JoinColumn(name="FK_ARTICLE")
	    )
	
	/**
	 * Includes a CASCADE actions
	 * to be more efectives when remove information
	 * */
	@ManyToMany(cascade = CascadeType.ALL)
	protected List<ArticleModel> articles;
	//Is protected because is better to manipulate in the controller
	
	/**Geters and Seters*/
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

	public List<ArticleModel> getArticles() {
		return articles;
	}

	public void setArticles(List<ArticleModel> articles) {
		this.articles = articles;
	}
	

}
