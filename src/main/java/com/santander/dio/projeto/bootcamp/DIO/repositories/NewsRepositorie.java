package com.santander.dio.projeto.bootcamp.DIO.repositories;

import com.santander.dio.projeto.bootcamp.DIO.entities.News;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NewsRepositorie extends JpaRepository<News, Long> {
}
