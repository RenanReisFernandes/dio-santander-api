package com.santander.dio.projeto.bootcamp.DIO.services;

import com.santander.dio.projeto.bootcamp.DIO.entities.User;
import com.santander.dio.projeto.bootcamp.DIO.repositories.UserRepositorie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepositorie userRepositorie;

    public User save(User user) {
        boolean existCpf = false;
        Optional<User> optUser = userRepositorie.findByCpf(user.getCpf());
        if (optUser.isPresent()) {
            if (!optUser.get().getId().equals(user.getId())) ;
            existCpf = true;
        }
        if (existCpf) {
            throw new RuntimeException("Usuário já cadastrado");
        }
        return userRepositorie.save(user);
    }

    public List<User> findAll() {
        return userRepositorie.findAll();
    }

    public Optional<User> findById(Long id) {
        return userRepositorie.findById(id);
    }

    public User update(User userUpdated, Long id) {
        Optional<User> optUser = userRepositorie.findById(id);
        if (optUser.isPresent()) {
            User userPresent = optUser.get();
            userPresent.setAddress(userUpdated.getAddress());
            userPresent.setCpf(userUpdated.getCpf());
            userPresent.setBirthDate(userUpdated.getBirthDate());
            userPresent.setPhoneNumber(userUpdated.getPhoneNumber());
            userPresent.setName(userUpdated.getName());

            return userRepositorie.save(userPresent);
        } else {
            throw new RuntimeException("Paciente " + id + " não encontrado!");
        }
    }

    public void delete(Long id) {
        userRepositorie.deleteById(id);
    }
}
