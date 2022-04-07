package com.demo.app.product.controllers;

import com.demo.app.product.entities.Card;
import com.demo.app.product.services.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/card")
public class CardController {
    @Autowired
    CardService cardService;

    @GetMapping
    private ResponseEntity<Flux<Card>> findAll(){
        Flux<Card> card = cardService.findAll();
        return ResponseEntity.ok(card);
    }

    @GetMapping("/{id}")
    private Mono<ResponseEntity<Card>> findById(@PathVariable String id){
        return cardService.findById(id).map(x->ResponseEntity.ok(x)).defaultIfEmpty(ResponseEntity.notFound().build());
    }

    @PostMapping
    private ResponseEntity<Mono<Card>> save(@RequestBody Card card){
        return ResponseEntity.ok(cardService.save(card));
    }
    @PutMapping("/{id}")
    private Mono<ResponseEntity<Card>> update(@RequestBody Card card, @PathVariable String id){
        return cardService.update(card,id).map(x->ResponseEntity.ok(x)).defaultIfEmpty(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    private Mono<ResponseEntity<Void>> delete(@PathVariable String id){
        return cardService.delete(id).map(x->ResponseEntity.ok(x)).defaultIfEmpty(ResponseEntity.notFound().build());
    }
}
