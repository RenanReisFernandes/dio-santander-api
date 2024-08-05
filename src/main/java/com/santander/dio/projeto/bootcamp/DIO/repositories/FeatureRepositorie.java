package com.santander.dio.projeto.bootcamp.DIO.repositories;

import com.santander.dio.projeto.bootcamp.DIO.entities.Feature;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FeatureRepositorie extends JpaRepository<Feature, Long> {
}
