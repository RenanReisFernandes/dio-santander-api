package com.santander.dio.projeto.bootcamp.DIO.repositories;

import com.santander.dio.projeto.bootcamp.DIO.entities.Card;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CardRepositorie extends JpaRepository<Card, Long> {
}
