package com.demo.app.product.repositories;

import com.demo.app.product.entities.Card;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CardRepository extends ReactiveMongoRepository<Card,String> {
}
