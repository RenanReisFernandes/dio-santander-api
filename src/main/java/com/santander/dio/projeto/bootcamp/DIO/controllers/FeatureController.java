package com.santander.dio.projeto.bootcamp.DIO.controllers;

import com.santander.dio.projeto.bootcamp.DIO.entities.Feature;
import com.santander.dio.projeto.bootcamp.DIO.services.FeatureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/feature")
public class FeatureController {
    @Autowired
    private FeatureService featureService;

    @PostMapping
    public ResponseEntity<Feature> save(@RequestBody Feature feature){
        Feature featureSaved = featureService.save(feature);
        return ResponseEntity.status(HttpStatus.CREATED).body(featureSaved);
    }

    @GetMapping
    public ResponseEntity<List<Feature>> findAll(){
        List<Feature> list = featureService.findAll();
        return ResponseEntity.status(HttpStatus.FOUND).body(list);
    }
}
