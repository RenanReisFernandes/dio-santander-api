package com.santander.dio.projeto.bootcamp.DIO.controllers;

import com.santander.dio.projeto.bootcamp.DIO.DTO.request.UserRequest;
import com.santander.dio.projeto.bootcamp.DIO.DTO.response.UserResponse;
import com.santander.dio.projeto.bootcamp.DIO.entities.User;
import com.santander.dio.projeto.bootcamp.DIO.mapper.UserMapper;
import com.santander.dio.projeto.bootcamp.DIO.services.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
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

    @Operation(summary = "Realiza inserção de usuários", method = "POST")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Inserção realizada com sucesso"),
            @ApiResponse(responseCode = "422", description = "Dados de requisição inválidos"),
            @ApiResponse(responseCode = "400", description = "Parâmetros inválidos"),
            @ApiResponse(responseCode = "401", description = "Usuário não encontrado"),
            @ApiResponse(responseCode = "500", description = "Erro de servidor")

    })
    @PostMapping
    public ResponseEntity<UserResponse> save(@RequestBody UserRequest userRequest){
        User user = UserMapper.toUser(userRequest);
        User userSaved = userService.save(user);
        UserResponse userResponse = UserMapper.toUserResponse(userSaved);
        return ResponseEntity.status(HttpStatus.CREATED).body(userResponse);
    }

    @Operation(summary = "Realiza busca de todos os usuários cadastrados", method = "GET")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Busca realizada com sucesso"),
            @ApiResponse(responseCode = "422", description = "Dados de requisição inválidos"),
            @ApiResponse(responseCode = "400", description = "Parâmetros inválidos"),
            @ApiResponse(responseCode = "401", description = "Usuário não encontrado"),
            @ApiResponse(responseCode = "500", description = "Erro de servidor")

    })
    @GetMapping
    public ResponseEntity<List<UserResponse>> findAll(){
        List<User> foundList = userService.findAll();
        List<UserResponse> userResponseList = UserMapper.toUserResponseList(foundList);
        return ResponseEntity.status(HttpStatus.FOUND).body(userResponseList);
    }

    @Operation(summary = "Realiza busca de um usuário através do ID", method = "GET")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Busca realizada com sucesso"),
            @ApiResponse(responseCode = "422", description = "Dados de requisição inválidos"),
            @ApiResponse(responseCode = "400", description = "Parâmetros inválidos"),
            @ApiResponse(responseCode = "401", description = "Usuário não encontrado"),
            @ApiResponse(responseCode = "500", description = "Erro de servidor")

    })
    @GetMapping(value = "/{id}")
    public ResponseEntity<UserResponse> findById(@PathVariable Long id){

        Optional<User> optUser = userService.findById(id);

        if(optUser.isEmpty()){
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }else {
            return ResponseEntity.status(HttpStatus.FOUND).body(UserMapper.toUserResponse(optUser.get()));
        }
    }

    @Operation(summary = "Realiza atualização dos dados de um usuário através do ID", method = "PUT")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Atualização realizada com sucesso"),
            @ApiResponse(responseCode = "422", description = "Dados de requisição inválidos"),
            @ApiResponse(responseCode = "400", description = "Parâmetros inválidos"),
            @ApiResponse(responseCode = "401", description = "Usuário não encontrado"),
            @ApiResponse(responseCode = "500", description = "Erro de servidor")

    })
    @PutMapping
    public ResponseEntity<UserResponse> update(@RequestBody UserRequest request){
        User user = UserMapper.toUser(request);
        User userSaved = userService.save(user);
        UserResponse response = UserMapper.toUserResponse(userSaved);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @Operation(summary = "Realiza deleção de um usuário através do ID", method = "DELETE")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Deleção realizada com sucesso"),
            @ApiResponse(responseCode = "422", description = "Dados de requisição inválidos"),
            @ApiResponse(responseCode = "400", description = "Parâmetros inválidos"),
            @ApiResponse(responseCode = "401", description = "Usuário não encontrado"),
            @ApiResponse(responseCode = "500", description = "Erro de servidor"),

    })
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        userService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
