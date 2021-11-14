package com.vasilisa.cinema.controller;

import com.vasilisa.cinema.controller.dto.UserDTO;
import com.vasilisa.cinema.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/users")
    public List<UserDTO> getAllUsers(){
        return userService.getAllUsers();
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/user/{id}")
    public UserDTO getUser(@PathVariable int id){
        return userService.getUser(id);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(value = "/user")
    public UserDTO createUser(@RequestBody UserDTO userDTO){
        return userService.createUser(userDTO);
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping(value = "/user/{id}")
    public UserDTO updateUser(@PathVariable int id, @RequestBody UserDTO userDTO){
        return userService.updateUser(id, userDTO);
    }

    @DeleteMapping(value = "/user/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable int id){
        userService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }
}
