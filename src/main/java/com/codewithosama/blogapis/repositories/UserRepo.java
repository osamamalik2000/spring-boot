package com.codewithosama.blogapis.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.codewithosama.blogapis.entities.User;

@Repository
public interface UserRepo extends JpaRepository<User, Integer>{
    
}
