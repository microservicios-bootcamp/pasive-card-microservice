package com.demo.app.product.repositories;


import com.demo.app.product.entities.CurrentAccount;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public interface CurrentAccountRepository extends ReactiveMongoRepository<CurrentAccount,String> {
    Mono<CurrentAccount> findByDni(String dni);
    Mono<CurrentAccount> findByDniAndAccountNumber(String dni,String account);
    Flux<CurrentAccount> findAllByDni(String dni);
}
