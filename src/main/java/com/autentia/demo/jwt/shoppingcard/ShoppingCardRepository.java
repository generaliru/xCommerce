package com.autentia.demo.jwt.shoppingcard;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShoppingCardRepository extends CrudRepository<ShoppingCardModel, Long> {
	//public abstract Optional<ShoppingCardModel> findByUser(); 
}
