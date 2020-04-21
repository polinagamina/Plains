package com.example.gamina.controllers;

import com.example.gamina.repositories.UsersRepository;
import com.example.gamina.tableObjects.Roles;
import com.example.gamina.tableObjects.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/user")
@PreAuthorize("hasAuthority('ADMIN')")
public class UsersController {

    private UsersRepository usersRepository;

    @Autowired
    public UsersController(UsersRepository usersRepository) {

        this.usersRepository = usersRepository;
    }

    @GetMapping
    public String userList(Map<String, Object> userList) {
        userList.put("users", usersRepository.findAll());
        return "userList";
    }

    @GetMapping("{user}")
    public String userEditForm(@PathVariable Users user,
                               Map<String, Object> model) {
        model.put("user", user);
        model.put("roles", Roles.values());
        return "userEditor";
    }

    @PostMapping
    public String saveUser(@RequestParam String username,
                           @RequestParam Map<String, String> form,
                           @RequestParam("userId") Users user) {
        user.setUsername(username);
        Set<String> roles = Arrays.stream(Roles.values())
                .map(Roles::name)
                .collect(Collectors.toSet());

        user.getRoles().clear();

        for (String key : form.keySet()) {
            if (roles.contains(key)) {
                user.getRoles().add(Roles.valueOf(key));
            }
        }
        usersRepository.save(user);
        return "redirect:/user";
    }
}