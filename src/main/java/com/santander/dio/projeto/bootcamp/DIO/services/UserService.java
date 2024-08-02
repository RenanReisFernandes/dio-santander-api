package com.santander.dio.projeto.bootcamp.DIO.services;

import com.santander.dio.projeto.bootcamp.DIO.entities.User;
import com.santander.dio.projeto.bootcamp.DIO.repositories.UserRepositorie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepositorie userRepositorie;

    public User create(User user){
        return  null;
    }

    public List<User> findAll(){
        return null;
    }

    public User findById(Long id){
        return null;
    }

    public User update(User user, Long id){
        return null;
    }

    public void delete(Long id){
        
    }
}
