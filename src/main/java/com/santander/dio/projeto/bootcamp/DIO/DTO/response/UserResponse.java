package com.santander.dio.projeto.bootcamp.DIO.DTO.response;

import com.santander.dio.projeto.bootcamp.DIO.entities.Account;
import com.santander.dio.projeto.bootcamp.DIO.entities.Card;
import com.santander.dio.projeto.bootcamp.DIO.entities.Feature;
import com.santander.dio.projeto.bootcamp.DIO.entities.News;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class UserResponse {

    private String name;
    @OneToMany
    private Set<Account> accounts;
    @OneToOne
    private Card card;
    @OneToMany
    private List<Feature> features;
    @OneToMany
    private List<News> news;
}
