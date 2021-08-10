package com.autentia.demo.jwt.shoppingcard;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.autentia.demo.jwt.article.ArticleModel;
import com.autentia.demo.jwt.article.ArticleRepository;
import com.autentia.demo.jwt.usuario.Usuario;

@RestController
//@RequestMapping("/carrito")  Se comentó porque causaba problemas en las peticiones a la API
public class ShoppingCardController {
	
	@Autowired
	ShoppingCardService shoppingcardService;
	
	@Autowired
	ArticleRepository articleRepository;
	
	/**		*It works localhost:8080/shoppingcards*
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
		
		Long id = card.getId();
		Usuario usuario = card.getUsuario();
		Long lot = card.getLot();
		ShoppingCardModel shoppingCardModel = new ShoppingCardModel();
		List<ArticleModel> articleModels = card.getArticles();
		
		
		if(id != null) {
			shoppingCardModel.setId(card.getId());
		}
		if(usuario != null) {			
			shoppingCardModel.setUsuario(usuario);
		}
		if(lot != 0) {
			shoppingCardModel.setLot(lot);			
		}		
		List<ArticleModel> articleModelList = new ArrayList<ArticleModel>();
		if(articleModels != null) {			
			for(ArticleModel articleModel: articleModels) {
				articleModelList.add(articleRepository.findById(articleModel.getId()).get());
			}
		}
		
		shoppingCardModel.setArticles(articleModelList);
		return shoppingcardService.saveCard(shoppingCardModel);
	}
	
	//Metodo para borrar carrito por id
	@DeleteMapping ("/shoppingcard/{id}")
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
	public boolean addArticleInCart(@RequestBody ArticleModel article){
        return shoppingcardService.saveArticleInShoppingCard(article);
    }
	
	/**   *   http://localhost:8080/cartbytoken*
	 * Allow obtains a cart by token of user logged.
	 * */
	@GetMapping("/cartbytoken")
	public ShoppingCardModel getCartByToken() {
		return shoppingcardService.getCartUser();
	}

}
