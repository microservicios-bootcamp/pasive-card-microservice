package com.demo.app.product.services.impl;

import com.demo.app.product.entities.Card;
import com.demo.app.product.repositories.CardRepository;
import com.demo.app.product.services.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class CardServiceImpl implements CardService {

    @Autowired
    CardRepository cardRepository;

    @Override
    public Flux<Card> findAll() {
        return cardRepository.findAll();
    }

    @Override
    public Mono<Card> save(Card card) {
        return cardRepository.save(card);
    }

    @Override
    public Mono<Card> findById(String id) {
        return cardRepository.findById(id);
    }

    @Override
    public Mono<Card> update(Card card, String id) {
        return cardRepository.findById(id).flatMap(x->{
            x.setCvc(card.getCvc());
            x.setAccountNumber(card.getAccountNumber());
            x.setCurrency(card.getCurrency());
            x.setBalance(card.getBalance());
            x.setAccountType(card.getAccountType());
            return cardRepository.save(x);
        });
    }

    @Override
    public Mono<Void> delete(String id) {
        return cardRepository.deleteById(id);
    }
}
