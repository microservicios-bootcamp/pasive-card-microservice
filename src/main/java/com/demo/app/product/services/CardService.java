package com.demo.app.product.services;

import com.demo.app.product.entities.Card;
import com.demo.app.product.entities.CardType;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface CardService {
    Flux<Card> findAll();
    Mono<Card> save(Card card);
    Flux<Card> saveAll(Flux<Card> cards);
    Mono<Boolean> findByDni(String dni);
    Mono<Boolean> findByDniCardType(String dni, CardType type);
    Mono<Card> update(Card card,String id);
    Mono<Void> delete(String id);
}
