package com.demo.app.product.repositories;

import com.demo.app.product.entities.SavingAccount;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public interface SavingAccountRepository extends ReactiveMongoRepository<SavingAccount,String> {
    Mono<SavingAccount> findByDni(String dni);
    Flux<SavingAccount> findAllByDni(String dni);
}
