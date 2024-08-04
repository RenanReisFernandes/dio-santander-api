package com.santander.dio.projeto.bootcamp.DIO.services;

import com.santander.dio.projeto.bootcamp.DIO.entities.Account;
import com.santander.dio.projeto.bootcamp.DIO.repositories.AccountRepositorie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountService {

    @Autowired
    private AccountRepositorie accountRepositorie;
    public Account save(Account account){
        Account accountCreated = accountRepositorie.save(account);
        return accountCreated;
    }
}
