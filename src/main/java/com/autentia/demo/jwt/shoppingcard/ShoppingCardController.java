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





}
