package com.santander.dio.projeto.bootcamp.DIO.services;

import com.santander.dio.projeto.bootcamp.DIO.entities.Account;
import com.santander.dio.projeto.bootcamp.DIO.repositories.AccountRepositorie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AccountService {

    @Autowired
    private AccountRepositorie accountRepositorie;

    public Account save(Account account){
        boolean existNumber = false;
        Optional<Account> existentAccount = accountRepositorie.findByNumber(account.getNumber());
        if(existentAccount.isPresent()){
            if(!existentAccount.get().getId().equals(account.getId()));
            existNumber = true;

            if(existNumber){
                throw new RuntimeException("Já existe uma conta criada com o id: "+ existNumber );
            }

        }
        return accountRepositorie.save(account);
    }
}
