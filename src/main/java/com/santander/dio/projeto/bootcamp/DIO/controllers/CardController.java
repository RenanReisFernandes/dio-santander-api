package com.santander.dio.projeto.bootcamp.DIO.controllers;

import com.santander.dio.projeto.bootcamp.DIO.entities.Card;
import com.santander.dio.projeto.bootcamp.DIO.services.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/card")
public class CardController {
    @Autowired
    private CardService cardService;

    @PostMapping
    public ResponseEntity<Card> save(@RequestBody Card card){
        Card cardCreated = cardService.save(card);
        return ResponseEntity.status(HttpStatus.CREATED).body(card);
    }

    @GetMapping
    public ResponseEntity<List<Card>> findAll(){
        List<Card> foundCard = cardService.findAll();
        return ResponseEntity.status(HttpStatus.FOUND).body(foundCard);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Card> findById(@PathVariable Long id){
        Optional<Card> optCard = cardService.findById(id);
        if(optCard.isEmpty()){
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
        return ResponseEntity.status(HttpStatus.OK).body(optCard.get());
    }

    @PutMapping
    public ResponseEntity<Card> update(@RequestBody Card card){
        Card cardUpdated = cardService.save(card);
        return  ResponseEntity.status(HttpStatus.OK).body(cardUpdated);
    }

}
