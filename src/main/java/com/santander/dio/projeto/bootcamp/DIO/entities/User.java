package com.santander.dio.projeto.bootcamp.DIO.entities;

import ch.qos.logback.core.boolex.EvaluationException;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
@Table(name = "tb_users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String cpf;
    private String phoneNumber;
    private LocalDate birthDate;
    private String address;
    @OneToMany
    private Set<Account> accounts;
    @OneToOne
    private Card card;
    @OneToMany
    private List<Feature> features;
    @OneToMany
    private List<News> news;
}
