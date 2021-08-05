package com.autentia.demo.jwt.usuario;

import java.sql.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.autentia.demo.jwt.shoppingcard.ShoppingCardModel;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

@Entity
@Table(name = "users")
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(nullable = false, length = 100, name = "username")
	private String username;
	
	@JsonProperty(access = Access.WRITE_ONLY)
	@Column(nullable = false, length = 100, name = "password")
	private String password;
	
	@Column(nullable = false, length = 100, name = "name")
	private String name;
	
	@Column(nullable = false, length = 100, unique = true, name = "email")
	private String email;
	
	@Column(nullable = false, name = "birthdate")
	private Date date;
	
	@Column(length = 250, name = "img")
	private String img;
	
	@OneToMany(targetEntity = ShoppingCardModel.class, cascade = CascadeType.ALL, mappedBy = "user")
	private List<ShoppingCardModel> shoppingCard;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public List<ShoppingCardModel> getShoppingCard() {
		return shoppingCard;
	}

	public void setShoppingCard(List<ShoppingCardModel> shoppingCard) {
		this.shoppingCard = shoppingCard;
	}

	
}
