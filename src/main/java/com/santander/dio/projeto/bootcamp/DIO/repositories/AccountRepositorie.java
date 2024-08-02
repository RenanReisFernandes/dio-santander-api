package com.santander.dio.projeto.bootcamp.DIO.repositories;

import com.santander.dio.projeto.bootcamp.DIO.entities.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepositorie extends JpaRepository<Account, Long> {
}
