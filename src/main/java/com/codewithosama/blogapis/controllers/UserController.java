package com.codewithosama.blogapis.controllers;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codewithosama.blogapis.payloads.UserDTO;
import com.codewithosama.blogapis.services.UserService;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    // POST-create user
    @PostMapping("/")
    public ResponseEntity<UserDTO> createUser(@RequestBody UserDTO userDTO){
        UserDTO createdUser = this.userService.createUser(userDTO);
        return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
    }

    // GET-all users
    @GetMapping("/")
    public List<UserDTO> getUsers(){
        return this.userService.getAllUsers();
    }

    // GET-user by id
    @GetMapping("/{userID}")
    public UserDTO getUserById(@PathVariable Integer userID){
        return this.userService.getUserById(userID);
    }

    // PUT-user
    @PutMapping("/{userID}")
    public ResponseEntity<UserDTO> updateUser(@RequestBody UserDTO userDTO, @PathVariable Integer userID) {
        return ResponseEntity.ok(this.userService.updateUser(userDTO, userID));
    }

    // DELETE-user
    @DeleteMapping("/{userID}")
    public ResponseEntity<?> deleteUser(@PathVariable Integer userID){
        this.userService.deleteUser(userID);
        return ResponseEntity.ok(Map.of("message", "User deleted successfully"));
    }
}
