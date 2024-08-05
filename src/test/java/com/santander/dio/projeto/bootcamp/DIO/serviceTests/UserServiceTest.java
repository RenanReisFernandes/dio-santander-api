package com.santander.dio.projeto.bootcamp.DIO.serviceTests;

import com.santander.dio.projeto.bootcamp.DIO.entities.User;
import com.santander.dio.projeto.bootcamp.DIO.repositories.UserRepositorie;
import com.santander.dio.projeto.bootcamp.DIO.services.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

    @Mock
    private UserRepositorie userRepositorie;

    @InjectMocks
    private UserService userService;

    private User user;
    private User updatedUser;

    @BeforeEach
    public void setUp() {
        user = new User();
        updatedUser = new User();
    }

    @Test
    public void testSave() {
        when(userRepositorie.findByCpf(user.getCpf())).thenReturn(Optional.empty());
        when(userRepositorie.save(user)).thenReturn(user);

        User savedUser = userService.save(user);

        assertEquals(user, savedUser);
        verify(userRepositorie, times(1)).findByCpf(user.getCpf());
        verify(userRepositorie, times(1)).save(user);
    }

    @Test
    public void testSaveUserAlreadyExists() {
        when(userRepositorie.findByCpf(user.getCpf())).thenReturn(Optional.of(user));

        Exception exception = assertThrows(RuntimeException.class, () -> {
            userService.save(user);
        });

        assertEquals("Usuário já cadastrado", exception.getMessage());
        verify(userRepositorie, times(1)).findByCpf(user.getCpf());
        verify(userRepositorie, times(0)).save(user);
    }

    @Test
    public void testFindAll() {
        List<User> userList = Arrays.asList(user);
        when(userRepositorie.findAll()).thenReturn(userList);

        List<User> result = userService.findAll();

        assertEquals(userList, result);
        verify(userRepositorie, times(1)).findAll();
    }

    @Test
    public void testFindById() {
        when(userRepositorie.findById(1L)).thenReturn(Optional.of(user));

        Optional<User> result = userService.findById(1L);

        assertTrue(result.isPresent());
        assertEquals(user, result.get());
        verify(userRepositorie, times(1)).findById(1L);
    }

    @Test
    public void testUpdate() {
        when(userRepositorie.findById(1L)).thenReturn(Optional.of(user));
        when(userRepositorie.save(any(User.class))).thenReturn(updatedUser);

        User result = userService.update(updatedUser, 1L);

        assertEquals(updatedUser.getCpf(), result.getCpf());
        assertEquals(updatedUser.getName(), result.getName());
        verify(userRepositorie, times(1)).findById(1L);
        verify(userRepositorie, times(1)).save(user);
    }

    @Test
    public void testUpdateNotFound() {
        when(userRepositorie.findById(1L)).thenReturn(Optional.empty());

        Exception exception = assertThrows(RuntimeException.class, () -> {
            userService.update(updatedUser, 1L);
        });

        assertEquals("Paciente 1 não encontrado!", exception.getMessage());
        verify(userRepositorie, times(1)).findById(1L);
        verify(userRepositorie, times(0)).save(any(User.class));
    }

    @Test
    public void testDelete() {
        doNothing().when(userRepositorie).deleteById(1L);

        userService.delete(1L);

        verify(userRepositorie, times(1)).deleteById(1L);
    }
}