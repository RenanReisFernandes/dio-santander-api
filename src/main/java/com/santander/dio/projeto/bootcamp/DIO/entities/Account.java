package com.santander.dio.projeto.bootcamp.DIO.entities;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
@Table(name = "tb_accounts")
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String number;
    @Column(nullable = false)
    private String agency;
    private BigDecimal balance;

    @Column(name = "account_limit", scale = 2, precision = 13)
    private BigDecimal accountLimit;
}
