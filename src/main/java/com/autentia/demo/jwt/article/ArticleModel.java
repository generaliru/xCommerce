package com.autentia.demo.jwt.article;

import java.util.List;

import javax.persistence.CascadeType;
/**
 * @author Yann
 *
 */
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.autentia.demo.jwt.shoppingcard.ShoppingCardModel;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

@Entity
@Table(name = "articles")
public class ArticleModel {
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(nullable = false)
	private Long id;

	@Column(nullable = false, length = 100, name = "name")
	private String name;
	
	@Column(nullable = false, length = 10, name = "price")
	private Float price;
	
	@Column(nullable = false, length = 50, name = "category")
	private String category;
	
	/*Puede alcanzar hasta 300 characters*/
	@Column(nullable = false, length = 400, name = "description")
	private String description;
	
	/*Las url no suelen exceder los 200 caracteres, pero es mejor dar mayor margen*/
	@Column(nullable = false, length = 250, name = "img1")
	private String img1;

	/*Las url no suelen exceder los 200 caracteres, pero es mejor dar mayor margen*/
	@Column(nullable = false, length = 250, name = "img2")
	private String img2;
	
	/*Las url no suelen exceder los 200 caracteres, pero es mejor dar mayor margen*/
	@Column(nullable = false, length = 250, name = "img3")
	private String img3;
	
	/*Las url no suelen exceder los 200 caracteres, pero es mejor dar mayor margen*/
	@Column(length = 250, name = "img4")
	private String img4;
	
	/*Es muy probable que no exceda los 10k elementos*/
	@Column(nullable = false, length = 4, name = "stock")
	private Integer stock;
	
	/**
	 * It's the correct way to relationship with ShoppingCard.
	 * Can relationship with the atribute "articles" of ShoppingCard
	 * that can be a List
	 * */
	@JsonProperty(access = Access.WRITE_ONLY)
	@ManyToMany(mappedBy = "articles")
	private List<ShoppingCardModel> shoppingCard;
	
	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
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
	 * @return the price
	 */
	public Float getPrice() {
		return price;
	}

	/**
	 * @param price the price to set
	 */
	public void setPrice(Float price) {
		this.price = price;
	}

	/**
	 * @return the category
	 */
	public String getCategory() {
		return category;
	}

	/**
	 * @param category the category to set
	 */
	public void setCategory(String category) {
		this.category = category;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the img1
	 */
	public String getImg1() {
		return img1;
	}

	/**
	 * @param img1 the img1 to set
	 */
	public void setImg1(String img1) {
		this.img1 = img1;
	}

	/**
	 * @return the img2
	 */
	public String getImg2() {
		return img2;
	}

	/**
	 * @param img2 the img2 to set
	 */
	public void setImg2(String img2) {
		this.img2 = img2;
	}

	/**
	 * @return the img3
	 */
	public String getImg3() {
		return img3;
	}

	/**
	 * @param img3 the img3 to set
	 */
	public void setImg3(String img3) {
		this.img3 = img3;
	}

	/**
	 * @return the img4
	 */
	public String getImg4() {
		return img4;
	}

	/**
	 * @param img4 the img4 to set
	 */
	public void setImg4(String img4) {
		this.img4 = img4;
	}

	/**
	 * @return the stock
	 */
	public Integer getStock() {
		return stock;
	}

	/**
	 * @param stock the stock to set
	 */
	public void setStock(Integer stock) {
		this.stock = stock;
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

	@Override
	public String toString() {
		return "ArticleModel [id=" + id + ", name=" + name + ", price=" + price + ", category=" + category
				+ ", description=" + description + ", img1=" + img1 + ", img2=" + img2 + ", img3=" + img3 + ", img4="
				+ img4 + ", stock=" + stock + ", shoppingCard=" + shoppingCard + "]";
	}
}
