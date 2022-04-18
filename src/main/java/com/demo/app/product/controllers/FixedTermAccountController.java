package com.demo.app.product.controllers;

import com.demo.app.product.entities.FixedTermAccount;
import com.demo.app.product.services.FixedTermAccountService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/fixedTermAccount")
@Tag(name = "Test APIs", description = "Test APIs for demo purpose")
public class FixedTermAccountController {
    private final FixedTermAccountService cardService;

    public FixedTermAccountController(FixedTermAccountService cardService) {
        this.cardService = cardService;
    }

    @GetMapping
    private ResponseEntity<Flux<FixedTermAccount>> findAll(){
        Flux<FixedTermAccount> card = cardService.findAll();
        return ResponseEntity.ok(card);
    }

    @GetMapping("/all/dni/{dni}")
    private Flux<FixedTermAccount> findAllByDni(@PathVariable String dni){
        return cardService.findAllByDni(dni);
    }

    @GetMapping("/dni/{dni}")
    private Mono<Boolean> findByDni(@PathVariable String dni){
        return cardService.findByDni(dni);
    }

    @GetMapping("/dni/{dni}/account/{account}")
    private Mono<FixedTermAccount> findByDniAndAccount(@PathVariable String dni,@PathVariable String account){
        return cardService.findByDniAndAccount(dni,account);
    }

    @PostMapping
    private ResponseEntity<Mono<FixedTermAccount>> save(@RequestBody FixedTermAccount card){
        return ResponseEntity.ok(cardService.save(card));
    }
    @PostMapping("/all")
    private ResponseEntity<Flux<FixedTermAccount>> saveAll(@RequestBody Flux<FixedTermAccount> cards){
        return ResponseEntity.ok(cardService.saveAll(cards));
    }
    @PutMapping("/{id}")
    private Mono<ResponseEntity<FixedTermAccount>> update(@RequestBody FixedTermAccount card, @PathVariable String id){
        return cardService.update(card,id).map(ResponseEntity::ok).defaultIfEmpty(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    private Mono<ResponseEntity<Void>> delete(@PathVariable String id){
        return cardService.delete(id).map(ResponseEntity::ok).defaultIfEmpty(ResponseEntity.notFound().build());
    }
}
