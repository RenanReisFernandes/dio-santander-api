package com.santander.dio.projeto.bootcamp.DIO.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/user")
public class UserController {

    @GetMapping
    public String retornaTeste(){
        return "Olá está functional";
   }
}
