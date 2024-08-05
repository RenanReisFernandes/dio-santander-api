package com.santander.dio.projeto.bootcamp.DIO.controllers;

import com.santander.dio.projeto.bootcamp.DIO.DTO.request.UserRequest;
import com.santander.dio.projeto.bootcamp.DIO.DTO.response.UserResponse;
import com.santander.dio.projeto.bootcamp.DIO.entities.User;
import com.santander.dio.projeto.bootcamp.DIO.mapper.UserMapper;
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
    public ResponseEntity<UserResponse> save(@RequestBody UserRequest userRequest){
        User user = UserMapper.toUser(userRequest);
        User userSaved = userService.save(user);
        UserResponse userResponse = UserMapper.toUserResponse(userSaved);
        return ResponseEntity.status(HttpStatus.CREATED).body(userResponse);
    }

    @GetMapping
    public ResponseEntity<List<User>> findAll(){
        List<User> foundList = userService.findAll();
        return ResponseEntity.status(HttpStatus.FOUND).body(foundList);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<UserResponse> findById(@PathVariable Long id){

        Optional<User> optUser = userService.findById(id);
        User user = UserMapper.toUserResponse(optUser);
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
