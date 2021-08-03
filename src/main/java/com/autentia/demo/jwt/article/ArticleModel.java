package com.autentia.demo.jwt.article;

/**
 * @author Yann
 *
 */
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "articles")
public class ArticleModel {
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(nullable = false)
	private long id;

	@Column(nullable = false, length = 100, name = "name")
	private String name;
	
	@Column(nullable = false, length = 10, name = "price")
	private Float price;
	
	@Column(nullable = false, length = 50, name = "category")
	private String category;
	
	/*Puede alcanzar hasta 300 characters*/
	@Column(nullable = false, length = 300, name = "description")
	private String description;
	
	/*Las url no suelen exceder los 200 caracteres, pero es mejor dar mayor margen*/
	@Column(nullable = false, length = 250, name = "img")
	private String img1;

	/*Las url no suelen exceder los 200 caracteres, pero es mejor dar mayor margen*/
	@Column(nullable = false, length = 250, name = "img")
	private String img2;
	
	/*Las url no suelen exceder los 200 caracteres, pero es mejor dar mayor margen*/
	@Column(nullable = false, length = 250, name = "img")
	private String img3;
	
	/*Las url no suelen exceder los 200 caracteres, pero es mejor dar mayor margen*/
	@Column(nullable = false, length = 250, name = "img")
	private String img4;
	
	/*Es muy probable que no exceda los 10k elementos*/
	@Column(nullable = false, length = 4, name = "stock")
	private Integer stock;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Float getPrice() {
		return price;
	}

	public void setPrice(Float price) {
		this.price = price;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getImg1() {
		return img1;
	}

	public void setImg1(String img1) {
		this.img1 = img1;
	}

	public String getImg2() {
		return img2;
	}

	public void setImg2(String img2) {
		this.img2 = img2;
	}

	public String getImg3() {
		return img3;
	}

	public void setImg3(String img3) {
		this.img3 = img3;
	}

	public String getImg4() {
		return img4;
	}

	public void setImg4(String img4) {
		this.img4 = img4;
	}

	public Integer getStock() {
		return stock;
	}

	public void setStock(Integer stock) {
		this.stock = stock;
	}
	

	
}
