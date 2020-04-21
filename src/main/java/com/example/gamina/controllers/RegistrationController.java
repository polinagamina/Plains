package com.example.gamina.controllers;

import com.example.gamina.repositories.UsersRepository;
import com.example.gamina.tableObjects.Roles;
import com.example.gamina.tableObjects.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;


import java.util.Collections;
import java.util.Map;

@Controller
public class RegistrationController {


    private UsersRepository usersRepository;
    @Autowired
    public RegistrationController(UsersRepository usersRepository){
        this.usersRepository=usersRepository;
    }
    @GetMapping("/registration")
    public String registration() {
        return "registration";
    }

    @PostMapping("/registration")
    public String addUser(Users user, Map<String, Object> model) {
        Users userFromDb = usersRepository.findByUsername(user.getUsername());
        if (userFromDb != null){
            model.put("errorMessage", "User already exists!");
            return "registration";
        }
        else{
            model.put("successMessage","You are successfully Sign Up!");
        }
        user.setActive(true);
        Iterable<Users> usersList=usersRepository.findAll();
        if (usersList.iterator().hasNext()) {
            user.setRoles(Collections.singleton(Roles.USER));
        } else {
            user.setRoles(Collections.singleton(Roles.ADMIN));
        }
        usersRepository.save(user);
        return "registration";
    }

}