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
		Long user_id=card.getUser_id();
		Long article_id=card.getArticle_id();
		Long lot=card.getLot();
		
		if(user_id != null && article_id != null && lot != null ) {
			return shoppingcardRepository.save(card);
		}
		return card;
	}


 


}
