package com.demo.app.product.services;

import com.demo.app.product.entities.Card;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface CardService {
    Flux<Card> findAll();
    Mono<Card> save(Card card);
    Mono<Card> findById(String id);
    Mono<Card> update(Card card,String id);
    Mono<Void> delete(String id);
}
