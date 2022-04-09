package com.demo.app.product.controllers;


import com.demo.app.product.entities.PasiveCard;
import com.demo.app.product.services.PasiveCardService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/pasive")
public class PasiveCardController {
    private final PasiveCardService cardService;

    public PasiveCardController(PasiveCardService cardService) {
        this.cardService = cardService;
    }

    @GetMapping
    private ResponseEntity<Flux<PasiveCard>> findAll(){
        Flux<PasiveCard> card = cardService.findAll();
        return ResponseEntity.ok(card);
    }

    @GetMapping("/dni/{dni}")
    private Mono<ResponseEntity<Boolean>> findByDni(@PathVariable String dni){
        return cardService.findByDni(dni).map(ResponseEntity::ok).defaultIfEmpty(ResponseEntity.notFound().build());
    }

    @PostMapping
    private ResponseEntity<Mono<PasiveCard>> save(@RequestBody PasiveCard card){
        return ResponseEntity.ok(cardService.save(card));
    }
    @PutMapping("/{id}")
    private Mono<ResponseEntity<PasiveCard>> update(@RequestBody PasiveCard card, @PathVariable String id){
        return cardService.update(card,id).map(ResponseEntity::ok).defaultIfEmpty(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    private Mono<ResponseEntity<Void>> delete(@PathVariable String id){
        return cardService.delete(id).map(ResponseEntity::ok).defaultIfEmpty(ResponseEntity.notFound().build());
    }
}
