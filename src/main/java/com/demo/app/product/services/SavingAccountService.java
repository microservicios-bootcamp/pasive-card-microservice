package com.demo.app.product.services;

import com.demo.app.product.entities.SavingAccount;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface SavingAccountService {
    Flux<SavingAccount> findAll();
    Mono<SavingAccount> save(SavingAccount card);
    Flux<SavingAccount> saveAll(Flux<SavingAccount> cards);
    Flux<SavingAccount> findAllByDni(String dni);
    Mono<Boolean> findByDni(String dni);
    Mono<SavingAccount> update(SavingAccount card,String id);
    Mono<Void> delete(String id);
}
