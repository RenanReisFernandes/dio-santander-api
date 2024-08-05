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
    public ResponseEntity<List<UserResponse>> findAll(){
        List<User> foundList = userService.findAll();
        List<UserResponse> userResponseList = UserMapper.toUserResponseList(foundList);
        return ResponseEntity.status(HttpStatus.FOUND).body(userResponseList);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<UserResponse> findById(@PathVariable Long id){

        Optional<User> optUser = userService.findById(id);

        if(optUser.isEmpty()){
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }else {
            return ResponseEntity.status(HttpStatus.FOUND).body(UserMapper.toUserResponse(optUser.get()));
        }
    }

    @PutMapping
    public ResponseEntity<UserResponse> update(@RequestBody UserRequest request){
        User user = UserMapper.toUser(request);
        User userSaved = userService.save(user);
        UserResponse response = UserMapper.toUserResponse(userSaved);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        userService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
