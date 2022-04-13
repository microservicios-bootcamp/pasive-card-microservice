package com.demo.app.product.repositories;

import com.demo.app.product.entities.FixedTermAccount;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public interface FixedTermAccountRepository extends ReactiveMongoRepository<FixedTermAccount,String> {
    Mono<FixedTermAccount> findByDni(String dni);
    Flux<FixedTermAccount> findAllByDni(String dni);
}
