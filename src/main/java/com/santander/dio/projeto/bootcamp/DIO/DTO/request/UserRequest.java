package com.santander.dio.projeto.bootcamp.DIO.DTO.request;

import jakarta.persistence.Column;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class UserRequest {
    @Column(unique = true)
    private String name;
    @Column(unique = true)
    private String cpf;
    @Column(unique = true)
    private String phoneNumber;
    @Column(unique = true)
    private LocalDate birthDate;
    @Column(unique = true)
    private String address;
}
