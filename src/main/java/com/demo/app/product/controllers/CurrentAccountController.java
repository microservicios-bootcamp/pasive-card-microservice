package com.demo.app.product.controllers;

import com.demo.app.product.entities.CurrentAccount;
import com.demo.app.product.services.CurrentAccountService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@Slf4j
@RequestMapping("/currentAccount")
@Tag(name = "Test APIs", description = "Test APIs for demo purpose")
public class CurrentAccountController {

    private final CurrentAccountService cardService;


    public CurrentAccountController(CurrentAccountService cardService) {
        this.cardService = cardService;
    }


    @GetMapping
    private ResponseEntity<Flux<CurrentAccount>> findAll(){
        return ResponseEntity.ok(cardService.findAll());
    }

    @GetMapping("/all/dni/{dni}")
    private Flux<CurrentAccount> findAllByDni(@PathVariable String dni){
        return cardService.findAllByDni(dni);
    }

    @GetMapping("/dni/{dni}")
    private Mono<Boolean> findByDni(@PathVariable String dni){
        return cardService.findByDni(dni);
    }

    @GetMapping("/dni/{dni}/account/{account}")
    private Mono<CurrentAccount> findByDni(@PathVariable String dni,@PathVariable String account){
        return cardService.findByDniAndAccount(dni,account);
    }

    @PostMapping
    private ResponseEntity<Mono<CurrentAccount>> save(@RequestBody CurrentAccount card){
        return ResponseEntity.ok(cardService.save(card));
    }
    @PostMapping("/all")
    private ResponseEntity<Flux<CurrentAccount>> saveAll(@RequestBody Flux<CurrentAccount> cards){
        return ResponseEntity.ok(cardService.saveAll(cards));
    }
    @PutMapping("/{id}")
    private Mono<ResponseEntity<CurrentAccount>> update(@RequestBody CurrentAccount card, @PathVariable String id){
        return cardService.update(card,id).map(ResponseEntity::ok).defaultIfEmpty(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    private Mono<ResponseEntity<Void>> delete(@PathVariable String id){
        return cardService.delete(id).map(ResponseEntity::ok).defaultIfEmpty(ResponseEntity.notFound().build());
    }
}
