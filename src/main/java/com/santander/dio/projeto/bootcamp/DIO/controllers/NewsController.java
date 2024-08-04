package com.santander.dio.projeto.bootcamp.DIO.controllers;

import com.santander.dio.projeto.bootcamp.DIO.entities.News;
import com.santander.dio.projeto.bootcamp.DIO.services.NewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/news")
public class NewsController {

    @Autowired
    private NewService newService;

    @PostMapping
    public ResponseEntity<News> save(@RequestBody News news){
        News newsSaved = newService.save(news);
        return  ResponseEntity.status(HttpStatus.CREATED).body(newsSaved);
    }
}
