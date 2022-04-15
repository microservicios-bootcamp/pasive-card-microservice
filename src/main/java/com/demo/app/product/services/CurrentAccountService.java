package com.demo.app.product.services;

import com.demo.app.product.entities.CurrentAccount;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface CurrentAccountService {
    Flux<CurrentAccount> findAll();
    Mono<CurrentAccount> save(CurrentAccount card);
    Flux<CurrentAccount> saveAll(Flux<CurrentAccount> cards);
    Flux<CurrentAccount> findAllByDni(String dni);
    Mono<CurrentAccount> findByDniAndAccount(String dni,String account);
    Mono<Boolean> findByDni(String dni);
    Mono<CurrentAccount> update(CurrentAccount card,String id);
    Mono<Void> delete(String id);
}
