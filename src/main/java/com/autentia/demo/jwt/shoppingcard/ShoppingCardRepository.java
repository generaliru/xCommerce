package com.autentia.demo.jwt.shoppingcard;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShoppingCardRepository extends CrudRepository<ShoppingCardModel, Long> {

}
