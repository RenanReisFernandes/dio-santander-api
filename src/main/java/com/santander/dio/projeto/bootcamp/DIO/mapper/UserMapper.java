package com.santander.dio.projeto.bootcamp.DIO.mapper;

import com.santander.dio.projeto.bootcamp.DIO.DTO.request.UserRequest;
import com.santander.dio.projeto.bootcamp.DIO.DTO.response.UserResponse;
import com.santander.dio.projeto.bootcamp.DIO.entities.User;

import java.util.ArrayList;
import java.util.List;

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

    public static List<UserResponse> toUserResponseList(List<User> users){
        List<UserResponse> responses = new ArrayList<>();
        for(User user : users){
            responses.add(toUserResponse(user));
        }
        return responses;
    }
}
