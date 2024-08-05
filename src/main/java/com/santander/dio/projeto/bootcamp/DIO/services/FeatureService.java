package com.santander.dio.projeto.bootcamp.DIO.services;

import com.santander.dio.projeto.bootcamp.DIO.entities.Feature;
import com.santander.dio.projeto.bootcamp.DIO.repositories.FeatureRepositorie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Service
public class FeatureService {
    @Autowired
    private FeatureRepositorie featureRepositorie;

    public Feature save(Feature feature) {
        return featureRepositorie.save(feature);
    }

    public List<Feature> findAll() {
        return featureRepositorie.findAll();
    }

    public Optional<Feature> findById(Long id) {
        return featureRepositorie.findById(id);
    }

    public Feature update(Feature upatedFeature, Long id) {
        Optional<Feature> optFeature = featureRepositorie.findById(id);

        if (optFeature.isPresent()) {
            Feature existentFeature = optFeature.get();

            existentFeature.setIcon(upatedFeature.getIcon());
            existentFeature.setDescription(upatedFeature.getDescription());

            return featureRepositorie.save(existentFeature);
        } else {
            throw new RuntimeException("Feature: " + id + " não encontrada!");
        }
    }

    public void delete(Long id){
        featureRepositorie.deleteById(id);
    }
}
