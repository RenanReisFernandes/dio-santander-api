package com.santander.dio.projeto.bootcamp.DIO.mapper;

import com.santander.dio.projeto.bootcamp.DIO.DTO.request.UserRequest;
import com.santander.dio.projeto.bootcamp.DIO.entities.User;

public class UserMapper {

    public static User toUser(UserRequest userRequest){
        User user = new User();
        user.setName(userRequest.getName());
        user.setCpf(userRequest.getCpf());
        user.setPhoneNumber(userRequest.getPhoneNumber());
        user.setBirthDate(userRequest.getBirthDate());
        user.setAddress(userRequest.getAddress());
        return user;
    }
}
