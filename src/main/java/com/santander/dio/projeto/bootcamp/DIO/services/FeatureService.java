package com.santander.dio.projeto.bootcamp.DIO.services;

import com.santander.dio.projeto.bootcamp.DIO.entities.Feature;
import com.santander.dio.projeto.bootcamp.DIO.repositories.FeatureRepositorie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FeatureService {
    @Autowired
    private FeatureRepositorie featureRepositorie;

    public Feature save(Feature feature){
        return featureRepositorie.save(feature);
    }
    
}
