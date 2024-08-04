package com.santander.dio.projeto.bootcamp.DIO.controllers;

import com.santander.dio.projeto.bootcamp.DIO.entities.News;
import com.santander.dio.projeto.bootcamp.DIO.services.NewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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

    @GetMapping
    public ResponseEntity<List<News>> findAll(){
        List<News> newsFound = newService.findAll();
        return ResponseEntity.status(HttpStatus.FOUND).body(newsFound);
    }

    @GetMapping("/{id}")
    public ResponseEntity<News> foundById(@PathVariable Long id){
        Optional<News>optNews = newService.findById(id);
        if(optNews.isEmpty()){
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }else{

           return ResponseEntity.status(HttpStatus.FOUND).body(optNews.get());
        }
    }

    @PutMapping
    public ResponseEntity<News> update(@RequestBody News news){
        News newsSaved = newService.save(news);
        return ResponseEntity.status(HttpStatus.OK).body(newsSaved);
    }

    public ResponseEntity<Void> delete(Long id){
        newService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
