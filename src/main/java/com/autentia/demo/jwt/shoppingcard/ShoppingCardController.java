package com.autentia.demo.jwt.shoppingcard;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.autentia.demo.jwt.article.ArticleModel;

@RestController
//@RequestMapping("/carrito")
public class ShoppingCardController {
	
	@Autowired
	ShoppingCardService shoppingcardService;
	
	/**		localhost:8080/shoppingcards*
	 * Catch the content of Protocol GET. 
	 * @return Articles all articles obtains in the query
	 * */
	@GetMapping(path="/shoppingcards")
	public ArrayList<ShoppingCardModel> getCard(){
		return shoppingcardService.getCards();
	}
	
	/**		*It Works localhost:8080/shoppingcards/*
	 * Catch the protocol POST to save an shoppingCard in the DB
	 * @param card is an ShoppingCard that could save.
	 * @return card cart saved in the DB.
	 * */
	@PostMapping("/shoppingcards/")
	public ShoppingCardModel saveCard(@RequestBody ShoppingCardModel card) {
		return shoppingcardService.saveCard(card);
	}
	
	//Metodo para borrar carrito por id
		@DeleteMapping (path="/shoppingcard/{id}")
		public String deleteCard(@PathVariable("id") Long id) {
			boolean ok=shoppingcardService.deleteCard(id);
			if(ok) {
				return  "Ha sido quitado con exito";
			}
			else {
				return "Error al quitar";
			}
		}


	/**		localhost:8080/articles-cart/
	 * Allow add an article in a cart
	 * @param article is an Article that could save in a shoppingCard.
	 * @param shoppingCard is an ShoppingCard that contains an article
	 * */
	@PostMapping("/articles-cart/")
	public void addArticleInCart(@RequestBody ShoppingCardModel shoppingCard, @RequestBody ArticleModel article){
        if(shoppingCard.getArticles() == null){
            shoppingCard.setArticles(new ArrayList<>());
        }
        
        shoppingCard.articles.add(article);
    }

}
