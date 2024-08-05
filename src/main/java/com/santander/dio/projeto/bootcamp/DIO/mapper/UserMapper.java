package com.santander.dio.projeto.bootcamp.DIO.mapper;

import com.santander.dio.projeto.bootcamp.DIO.DTO.request.UserRequest;
import com.santander.dio.projeto.bootcamp.DIO.DTO.response.UserResponse;
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

    public static UserResponse toUserResponse(User user){
        UserResponse userResponse = new UserResponse();
        userResponse.setName(user.getName());
        userResponse.setAccounts(user.getAccounts());
        userResponse.setCard(user.getCard());
        userResponse.setNews(user.getNews());
        userResponse.setFeatures(user.getFeatures());
        return userResponse;
    }
}
