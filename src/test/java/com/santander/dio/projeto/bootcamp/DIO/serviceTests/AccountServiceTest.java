package com.santander.dio.projeto.bootcamp.DIO.serviceTests;

import com.santander.dio.projeto.bootcamp.DIO.entities.Account;
import com.santander.dio.projeto.bootcamp.DIO.repositories.AccountRepositorie;
import com.santander.dio.projeto.bootcamp.DIO.services.AccountService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class AccountServiceTest {

    @InjectMocks
    private AccountService accountService;

    @Mock
    private AccountRepositorie accountRepositorie;

    private Account account;

    @BeforeEach
    public void setUp() {
        account = new Account();
        account.setId(1L);
        account.setNumber("12345");
        account.setAgency("123");
        account.setBalance(1000.0);
        account.setAccountLimit(500.0);
    }

    @Test
    public void testSave() {
        when(accountRepositorie.findByNumber(account.getNumber())).thenReturn(Optional.empty());
        when(accountRepositorie.save(account)).thenReturn(account);

        Account savedAccount = accountService.save(account);

        assertNotNull(savedAccount);
        assertEquals(account.getNumber(), savedAccount.getNumber());
        verify(accountRepositorie, times(1)).save(account);
    }

    @Test
    public void testSaveThrowsExceptionWhenAccountExists() {
        Account existentAccount = new Account();
        existentAccount.setId(2L);
        existentAccount.setNumber("12345");

        when(accountRepositorie.findByNumber(account.getNumber())).thenReturn(Optional.of(existentAccount));

        Exception exception = assertThrows(RuntimeException.class, () -> {
            accountService.save(account);
        });

        assertEquals("Já existe uma conta criada com o id: true", exception.getMessage());
    }

    @Test
    public void testFindAll() {
        List<Account> accounts = Arrays.asList(account);
        when(accountRepositorie.findAll()).thenReturn(accounts);

        List<Account> foundAccounts = accountService.findAll();

        assertEquals(1, foundAccounts.size());
        verify(accountRepositorie, times(1)).findAll();
    }

    @Test
    public void testFindById() {
        when(accountRepositorie.findById(1L)).thenReturn(Optional.of(account));

        Optional<Account> foundAccount = accountService.findById(1L);

        assertTrue(foundAccount.isPresent());
        assertEquals(account.getId(), foundAccount.get().getId());
        verify(accountRepositorie, times(1)).findById(1L);
    }

    @Test
    public void testUpdate() {
        Account updatedAccount = new Account();
        updatedAccount.setNumber("54321");
        updatedAccount.setAgency("321");
        updatedAccount.setBalance(2000.0);
        updatedAccount.setAccountLimit(1000.0);

        when(accountRepositorie.findById(1L)).thenReturn(Optional.of(account));

        Account updated = accountService.update(1L, updatedAccount);

        assertEquals(updatedAccount.getNumber(), updated.getNumber());
        assertEquals(updatedAccount.getAgency(), updated.getAgency());
        assertEquals(updatedAccount.getBalance(), updated.getBalance());
        assertEquals(updatedAccount.getAccountLimit(), updated.getAccountLimit());
        verify(accountRepositorie, times(1)).findById(1L);
        verify(accountRepositorie, times(1)).save(account);
    }

    @Test
    public void testUpdateThrowsExceptionWhenAccountNotFound() {
        Account updatedAccount = new Account();

        when(accountRepositorie.findById(1L)).thenReturn(Optional.empty());

        Exception exception = assertThrows(RuntimeException.class, () -> {
            accountService.update(1L, updatedAccount);
        });

        assertEquals("Conta : 1 não encontrada!", exception.getMessage());
    }

    @Test
    public void testDelete() {
        accountService.delete(1L);
        verify(accountRepositorie, times(1)).deleteById(1L);
    }
}