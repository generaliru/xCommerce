package com.autentia.demo.jwt.shoppingcard;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.autentia.demo.jwt.article.ArticleModel;
import com.autentia.demo.jwt.article.ArticleRepository;
import com.autentia.demo.jwt.usuario.Usuario;
import com.autentia.demo.jwt.usuario.UsuarioRepository;

@Service
public class ShoppingCardService {
	
	@Autowired
	ShoppingCardRepository shoppingcardRepository;
	
	@Autowired
	UsuarioRepository usuarioRepository;
<<<<<<< HEAD
=======
	
	@Autowired
	ArticleRepository articleRepository;
>>>>>>> 3aeeb2b9b7ea0ca8880c0b69e5c55eb8d58259f3
	
	public ArrayList<ShoppingCardModel> getCards(){
		return (ArrayList<ShoppingCardModel>) shoppingcardRepository.findAll();
	}
	
	
	public ShoppingCardModel saveCard (ShoppingCardModel card) {
		Long lot=card.getLot();
		
		if(lot != null ) {
			return shoppingcardRepository.save(card);
		}
		return card;
	}
	
	/* Borramos carrito*/
	public boolean deleteCard (Long id) {
		try {
			
			Usuario usuario = usuarioRepository.findByUsername((String) (SecurityContextHolder.getContext().getAuthentication().getPrincipal()));			
			ShoppingCardModel shoppingCardModel = usuario.getShoppingCard();
			List<ArticleModel> articleModels = shoppingCardModel.getArticles();
			
			Optional<ArticleModel> optionalArticleModel = articleRepository.findById(id);
			boolean state  = articleModels.remove(optionalArticleModel.get());
			if(state) {				
				shoppingCardModel.setArticles(articleModels);
				shoppingcardRepository.save(shoppingCardModel);
			}
			return state;
		} catch (Exception error) {
			System.out.println(error);
			return false;
		}
	}

	

	/**
	 * Obtains a ShoppingCart by the token of login of the user.
	 * @return ShoppingCardModel return the cart asigment to user.
	 * */
	public ShoppingCardModel getCartUser() {
		Usuario usuario = usuarioRepository.findByUsername((String) (SecurityContextHolder.getContext().getAuthentication().getPrincipal()));
		return usuario.getShoppingCard();
	}


}
