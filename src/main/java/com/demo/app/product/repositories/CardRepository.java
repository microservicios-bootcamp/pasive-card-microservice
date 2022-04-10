package com.demo.app.product.repositories;

import com.demo.app.product.entities.Card;
import com.demo.app.product.entities.CardType;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public interface CardRepository extends ReactiveMongoRepository<Card,String> {
    Mono<Card> findByDniAndCardType(String dni, CardType type);
    Mono<Card> findByDni(String dni);
}
