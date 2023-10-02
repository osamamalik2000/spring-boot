package com.codewithosama.blogapis.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codewithosama.blogapis.entities.User;
import com.codewithosama.blogapis.exceptions.ResourceNotFoundException;
import com.codewithosama.blogapis.payloads.UserDTO;
import com.codewithosama.blogapis.repositories.UserRepo;
import com.codewithosama.blogapis.services.UserService;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepo userRepo;

    @Override
    public UserDTO createUser(UserDTO userDTO) {
        User user = this.dtoToEntity(userDTO);
        User savedUser = this.userRepo.save(user);

        return this.userToDTO(savedUser);
    }

    @Override
    public UserDTO updateUser(UserDTO userDTO, Integer userID) {

        User user = this.userRepo.findById(userID).orElseThrow(() -> new ResourceNotFoundException("User", " id", userID));


        user.setName(userDTO.getName());
        user.setEmail(userDTO.getEmail());        
        user.setAbout(userDTO.getAbout());        

        User updatedUser = this.userRepo.save(user);
        UserDTO userDTO1 = this.userToDTO(updatedUser);

        return userDTO1;
    }

    @Override
    public UserDTO getUserById(Integer userID) {
        
        User user = this.userRepo.findById(userID).orElseThrow(() -> new ResourceNotFoundException("User", " id", userID));

        UserDTO userDTO = this.userToDTO(user);

        return userDTO;
    }

    @Override
    public List<UserDTO> getAllUsers() {
        List<User> users = this.userRepo.findAll();


        List<UserDTO> userDTOs = users.stream().map(user -> userToDTO(user)).collect(Collectors.toList());

        return userDTOs;
    }

    @Override
    public void deleteUser(Integer userID) {
        User user = this.userRepo.findById(userID).orElseThrow(() -> new ResourceNotFoundException("User", " id", userID));

        this.userRepo.delete(user);
    }


    // Temp methods
    private User dtoToEntity(UserDTO userDto){
        User user = new User();
        user.setId(userDto.getId());        
        user.setAbout(userDto.getAbout());
        user.setName(userDto.getName());
        user.setEmail(userDto.getEmail());
        user.setPassword(userDto.getPassword());

        return user;
    }

    private UserDTO userToDTO(User user){
        UserDTO userDTO = new UserDTO();
        userDTO.setId(user.getId());        
        userDTO.setAbout(user.getAbout());
        userDTO.setName(user.getName());
        userDTO.setEmail(user.getEmail());
        userDTO.setPassword(user.getPassword());

        return userDTO;
    }
}
