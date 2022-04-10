package com.demo.app.product.controllers;


import com.demo.app.product.entities.Card;
import com.demo.app.product.entities.CardType;
import com.demo.app.product.services.CardService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/card")
public class CardController {
    private final CardService cardService;

    public CardController(CardService cardService) {
        this.cardService = cardService;
    }

    @GetMapping
    private ResponseEntity<Flux<Card>> findAll(){
        Flux<Card> card = cardService.findAll();
        return ResponseEntity.ok(card);
    }

    @GetMapping("/dni/{dni}")
    private Mono<Boolean> findByDni(@PathVariable String dni){
        return cardService.findByDni(dni);
    }

    @GetMapping("/dni/{dni}/type/{type}")
    private Mono<Boolean> findByDniCardType(@PathVariable String dni,@PathVariable CardType type){
        return cardService.findByDniCardType(dni,type);
    }

    @PostMapping
    private ResponseEntity<Mono<Card>> save(@RequestBody Card card){
        return ResponseEntity.ok(cardService.save(card));
    }
    @PostMapping("/all")
    private ResponseEntity<Flux<Card>> saveAll(@RequestBody Flux<Card> cards){
        return ResponseEntity.ok(cardService.saveAll(cards));
    }
    @PutMapping("/{id}")
    private Mono<ResponseEntity<Card>> update(@RequestBody Card card, @PathVariable String id){
        return cardService.update(card,id).map(ResponseEntity::ok).defaultIfEmpty(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    private Mono<ResponseEntity<Void>> delete(@PathVariable String id){
        return cardService.delete(id).map(ResponseEntity::ok).defaultIfEmpty(ResponseEntity.notFound().build());
    }
}
