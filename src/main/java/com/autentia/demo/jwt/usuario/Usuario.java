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
	
	@OneToMany(targetEntity = ShoppingCardModel.class, cascade = CascadeType.ALL, mappedBy = "user")
	private List<ShoppingCardModel> shoppingCard;

	public long getId() {
		return id;
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

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the date
	 */
	public Date getDate() {
		return date;
	}

	/**
	 * @param date the date to set
	 */
	public void setDate(Date date) {
		this.date = date;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(long id) {
		this.id = id;
	}

	/**
	 * @return the shoppingCard
	 */
	public List<ShoppingCardModel> getShoppingCard() {
		return shoppingCard;
	}

	/**
	 * @param shoppingCard the shoppingCard to set
	 */
	public void setShoppingCard(List<ShoppingCardModel> shoppingCard) {
		this.shoppingCard = shoppingCard;
	}
}
