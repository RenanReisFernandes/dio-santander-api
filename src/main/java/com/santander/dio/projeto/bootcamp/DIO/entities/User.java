package com.santander.dio.projeto.bootcamp.DIO.entities;

import ch.qos.logback.core.boolex.EvaluationException;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
@Entity
@Table(name = "tb_users")
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode

public class User {

    private long id;
    private String name;
    private String phoneNumber;
    private LocalDate birthDate;
}
