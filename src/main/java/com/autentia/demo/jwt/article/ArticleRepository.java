package com.autentia.demo.jwt.article;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArticleRepository extends CrudRepository<ArticleModel , Long>{
	
	/**
	 * Obtains articles in function of name contains in the Query
	 * @Param name String that representate name of the article.
	 * */
	public abstract ArrayList<ArticleModel> findByNameContaining(String name);
	
	/**
	 * Obtains articles in function of Category contains in the Query
	 * @Param Category String that representate Category of the article.
	 * */
	public abstract ArrayList<ArticleModel> findByCategory(String category);
}
 