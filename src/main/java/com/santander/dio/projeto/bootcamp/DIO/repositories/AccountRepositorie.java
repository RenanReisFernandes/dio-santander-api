package com.santander.dio.projeto.bootcamp.DIO.repositories;

import com.santander.dio.projeto.bootcamp.DIO.entities.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AccountRepositorie extends JpaRepository<Account, Long> {
    Optional<Account> findByNumber(String number);
}
