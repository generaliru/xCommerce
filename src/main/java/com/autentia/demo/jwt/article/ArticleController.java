package com.autentia.demo.jwt.article;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.autentia.demo.jwt.usuario.Usuario;

@RestController
//@RequestMapping(path="/article")
public class ArticleController {
	
	@Autowired
	ArticleService articleService;
	
	/**		*It works localhost:8080/articles*
	 * Catch the content of Protocol GET. 
	 * @return Articles all articles obtains in the query
	 * */
	@GetMapping(path="/articles")
	public ArrayList<ArticleModel> getArticle(){
		return articleService.getArticles();
	}
	
	/**		*It Works localhost:8080/articles/*
	 * Catch the protocol POST to save an article in the DB
	 * @param article is an Article that could save.
	 * @return article saved.
	 * */
	@PostMapping("/articles/")
	public ArticleModel saveArticle(@RequestBody ArticleModel article) {
		System.out.println(article);
		return articleService.saveArticle(article);
	}
	
	/**		*It works localhost:8080/article/5*
	 * Catch the content of Protocol GET
	 * @param id is the param to search with the query
	 * @return Articles all articles obtains in the query
	 * */
	@GetMapping(path="/article/{id}")
	public Optional<ArticleModel> getArticleById(@PathVariable("id") Long id){
		return articleService.getArticleById(id);
	}
	
	
	/**		*It works localhost:8080/article/5*
	 * Can delete an Article in the DataBase
	 * @param id to delete an article.
	 * @return boolean if the service can delete or not.
	 * */
	@DeleteMapping(path="/article/{id}")
	public String deleteArticle(@PathVariable("id") Long id) {
		boolean ok = articleService.deleteArticle(id);
		if(ok) {
			return  "the item was successfully removed ";
		}
		else {
			return "the item was'nt removed ";
		}
	}
	
	/**		*It works localhost:8080/article/name?name=halo*
	 * Catch the content of Protocol GET
	 * @param id is the param to search with the query
	 * @return Articles all articles obtains in the query
	 * */
	@GetMapping(path="/article/name")
	public ArrayList<ArticleModel> getArticlesByName( @RequestParam(value = "name" , defaultValue="") String name){
		return articleService.getArticlesByName(name);
	}
	
	/** *It works localhost:8080/article/category?tag=gamer*
	 * Catch the content of Protocol GET
	 * @param category is the param to search with the query
	 * @return Articles all articles obtains in the query
	 * */
	@GetMapping(path="/article/category")
	public ArrayList<ArticleModel> getArticlesByCategory( @RequestParam(value = "tag" , defaultValue="") String Category){
		return articleService.getArticlesByCategory(Category);
	}
	
	
	/** *It works localhost:8080/article/categories*
	 * Catch the content of Protocol GET
	 * @param category is the param to search with the query
	 * @return Articles a Count of articles in a Category and the name of categories
	 * */
	@GetMapping(path="/article/categories")
	public List<String> getCategoriesAndCount( ){
		return articleService.getCategoriesAndCount();
	}
	
}