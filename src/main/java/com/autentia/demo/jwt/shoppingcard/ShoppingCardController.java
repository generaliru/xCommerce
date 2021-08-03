package com.autentia.demo.jwt.shoppingcard;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/carrito")
public class ShoppingCardController {
	
	@Autowired
	ShoppingCardService shoppingcardService;
	
	@GetMapping
	public ArrayList<ShoppingCardModel> getCards(){
		return shoppingcardService.getCards();
	}
	
	@PostMapping
	public ShoppingCardModel saveCard(@RequestBody ShoppingCardModel card) {
		return shoppingcardService.saveCard(card);
	}




}
