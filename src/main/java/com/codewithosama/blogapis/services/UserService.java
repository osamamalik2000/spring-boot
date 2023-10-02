package com.codewithosama.blogapis.services;

import java.util.List;

import com.codewithosama.blogapis.payloads.UserDTO;

public interface UserService {
    
    UserDTO createUser(UserDTO user);

    UserDTO updateUser(UserDTO user, Integer userID);

    UserDTO getUserById(Integer userID);

    List<UserDTO> getAllUsers();
    
    void deleteUser(Integer userId);

}
