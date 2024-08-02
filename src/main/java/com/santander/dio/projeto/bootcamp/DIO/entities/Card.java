package com.santander.dio.projeto.bootcamp.DIO.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Table(name = "tb_cards")
public class Card {

    private Long id;
    private String number;
    private Double limit;
}
