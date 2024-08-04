package com.santander.dio.projeto.bootcamp.DIO.controllers;

import com.santander.dio.projeto.bootcamp.DIO.entities.Account;
import com.santander.dio.projeto.bootcamp.DIO.services.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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

    @GetMapping
    public ResponseEntity<List<Account>> listAll(){
        List<Account> listFound = accountService.findAll();
        return ResponseEntity.status(HttpStatus.FOUND).body(listFound);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Account> findById(@PathVariable Long id){
        Optional<Account> optAccount = accountService.findById(id);
        if(optAccount.isEmpty()){
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
        Account accountFound = optAccount.get();
        return ResponseEntity.status(HttpStatus.FOUND).body(optAccount.get());
    }

    public ResponseEntity<Void> delete(Long id){
        accountService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}
