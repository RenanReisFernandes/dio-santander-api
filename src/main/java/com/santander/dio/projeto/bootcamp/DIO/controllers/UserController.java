package com.santander.dio.projeto.bootcamp.DIO.controllers;

import com.santander.dio.projeto.bootcamp.DIO.entities.User;
import com.santander.dio.projeto.bootcamp.DIO.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/user")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<User> save(@RequestBody User user){
        User userSaved = userService.save(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(userSaved);
    }

    @GetMapping
    public ResponseEntity<List<User>> findAll(){
        List<User> foundList = userService.findAll();
        return ResponseEntity.status(HttpStatus.FOUND).body(foundList);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<User> findById(@PathVariable Long id){
        Optional<User> optUser = userService.findById(id);
        if(optUser.isEmpty()){
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }else {
            User userFound = optUser.get();
            return ResponseEntity.status(HttpStatus.FOUND).body(optUser.get());
        }
    }

    @PutMapping
    public ResponseEntity<User> update(@RequestBody User userUpdated){
        User userSaved = userService.save(userUpdated);
        return ResponseEntity.status(HttpStatus.OK).body(userSaved);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        userService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
