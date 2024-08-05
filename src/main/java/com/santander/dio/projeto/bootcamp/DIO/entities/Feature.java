package com.santander.dio.projeto.bootcamp.DIO.entities;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;

@Entity
@Transactional
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Table(name = "tb_features")
public class Feature {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String icon;
    private String description;

}
