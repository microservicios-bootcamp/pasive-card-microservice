package com.demo.app.product.repositories;

import com.demo.app.product.entities.AccountType;
import com.demo.app.product.entities.Card;
import com.demo.app.product.entities.CardType;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public interface CardRepository extends ReactiveMongoRepository<Card,String> {
    Flux<Card> findAllByDniAndCardType(String dni, CardType type);
    Mono<Card> findByDni(String dni);
    Flux<Card> findAllByDni(String dni);
    Flux<Card> findAllByAccountType(AccountType type);
}
