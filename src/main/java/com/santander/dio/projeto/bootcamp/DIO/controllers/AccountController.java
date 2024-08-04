package com.santander.dio.projeto.bootcamp.DIO.controllers;

import com.santander.dio.projeto.bootcamp.DIO.entities.Account;
import com.santander.dio.projeto.bootcamp.DIO.services.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/account")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @PostMapping
    public ResponseEntity<Account> save(@RequestBody Account account){
        Account accountSaved = accountService.save(account);
        return  ResponseEntity.status(HttpStatus.CREATED).body(accountSaved);
    }

    public ResponseEntity<List<Account>> listAll(){
        List<Account> listFound = accountService.findAll();
        return ResponseEntity.status(HttpStatus.FOUND).body(listFound);
    }
}
