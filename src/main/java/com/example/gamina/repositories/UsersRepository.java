package com.example.gamina.repositories;


import com.example.gamina.tableObjects.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersRepository extends JpaRepository<Users, Integer> {

    Users findByUsername(String username);
}