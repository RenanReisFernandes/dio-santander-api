package com.santander.dio.projeto.bootcamp.DIO.controllers;

import com.santander.dio.projeto.bootcamp.DIO.entities.Card;
import com.santander.dio.projeto.bootcamp.DIO.services.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    
}
