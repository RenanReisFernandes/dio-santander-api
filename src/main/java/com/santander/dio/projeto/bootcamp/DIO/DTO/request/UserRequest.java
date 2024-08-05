package com.santander.dio.projeto.bootcamp.DIO.DTO.request;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class UserRequest {

    private String name;
    private String cpf;
    private String phoneNumber;
    private LocalDate birthDate;
    private String address;
}
