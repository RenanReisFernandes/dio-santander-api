package com.santander.dio.projeto.bootcamp.DIO.services;

import com.santander.dio.projeto.bootcamp.DIO.entities.Card;
import com.santander.dio.projeto.bootcamp.DIO.repositories.CardRepositorie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CardService {
    @Autowired
    private CardRepositorie cardRepositorie;

    public Card save(Card card){
        boolean existentCard = false;
        Optional<Card> optCard = cardRepositorie.findByNumber(card.getNumber());
        if(optCard.isPresent()){
            if(!optCard.get().getId().equals(card.getId()));
            existentCard = true;
        }if(existentCard){
            throw new RuntimeException("O cartão: "+ card.getId()+ " já está cadastrado no sistema");
        }
        return cardRepositorie.save(card);
    }

    public List<Card> findAll(){
        List<Card> cardFound = cardRepositorie.findAll();
        return cardFound;
    }

    public Optional<Card> findById(Long id){
        return cardRepositorie.findById(id);
    }

    public Card update(Card cardSaved, Long id){
        Optional<Card> optCard = cardRepositorie.findById(id);

        if(optCard.isPresent()){
            Card existentCard = optCard.get();

            existentCard.setNumber(cardSaved.getNumber());
            existentCard.setLimit(cardSaved.getLimit());

            cardRepositorie.save(existentCard);
        }
        throw new RuntimeException("Cartão : "+ id + "não encontrado");
    }

    public void  delete(Long id){
        cardRepositorie.deleteById(id);
    }
}
