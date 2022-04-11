package com.demo.app.product.services.impl;


import com.demo.app.product.entities.Card;
import com.demo.app.product.entities.CardType;
import com.demo.app.product.repositories.CardRepository;
import com.demo.app.product.services.CardService;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class CardServiceImpl implements CardService {

    private final CardRepository cardRepository;

    public CardServiceImpl(CardRepository cardRepository) {
        this.cardRepository = cardRepository;
    }

    @Override
    public Flux<Card> findAll() {
        return cardRepository.findAll();
    }

    @Override
    public Mono<Card> save(Card card) {
        return cardRepository.save(card);
    }



    @Override
    public Flux<Card> saveAll(Flux<Card> cards) {
        return cardRepository.saveAll(cards);
    }

    @Override
    public Flux<Card> findAllByDni(String dni) {
        return cardRepository.findAllByDni(dni);
    }

    @Override
    public Mono<Boolean> findByDni(String dni) {
        return cardRepository.findByDni(dni).hasElement().flatMap(x->{
            if(x)return Mono.just(true);
            return Mono.just(false);
        });
    }
    @Override
    public Mono<Boolean> findByDniCardType(String dni, CardType type) {
        return cardRepository.findAllByDniAndCardType(dni,type).hasElements().flatMap(x->{
            if(x)return Mono.just(true);
            return Mono.just(false);
        });
    }

    @Override
    public Mono<Card> update(Card card, String id) {
        return cardRepository.findById(id).flatMap(x->{
            x.setCvc(card.getCvc());
            x.setAccountNumber(card.getAccountNumber());
            x.setCurrency(card.getCurrency());
            x.setBalance(card.getBalance());
            x.setAccountType(card.getAccountType());
            x.setDni(card.getDni());
            x.setCardType(card.getCardType());
            return cardRepository.save(x);
        });
    }

    @Override
    public Mono<Void> delete(String id) {
        return cardRepository.deleteById(id);
    }
}
