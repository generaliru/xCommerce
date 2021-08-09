package com.autentia.demo.jwt.shoppingcard;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.autentia.demo.jwt.usuario.Usuario;
import com.autentia.demo.jwt.usuario.UsuarioRepository;

@Service
public class ShoppingCardService {
	
	@Autowired
	ShoppingCardRepository shoppingcardRepository;
	
	@Autowired
	UsuarioRepository usuarioRepository;
	
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

	/**
	 * Obtains a ShoppingCart by the token of login of the user.
	 * @return ShoppingCardModel return the cart asigment to user.
	 * */
	public ShoppingCardModel getCartUser() {
		Usuario usuario = usuarioRepository.findByUsername((String) (SecurityContextHolder.getContext().getAuthentication().getPrincipal()));
		return usuario.getShoppingCard();
	}


}
