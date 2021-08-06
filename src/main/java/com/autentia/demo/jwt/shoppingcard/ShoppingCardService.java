package com.autentia.demo.jwt.shoppingcard;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShoppingCardService {
	
	@Autowired
ShoppingCardRepository shoppingcardRepository;
	
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
			 shoppingcardRepository.deleteById(id);
		return true;
		} catch (Exception error) {
		return false;
		}
	}

	


 


}
