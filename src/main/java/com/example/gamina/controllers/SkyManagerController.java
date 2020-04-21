package com.example.gamina.controllers;

import com.example.gamina.repositories.SkyManagerRepository;
import com.example.gamina.tableObjects.SkyManager;
import com.example.gamina.tableObjects.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

@Controller
public class SkyManagerController {
    private SkyManagerRepository managersRepository;

    @Autowired
    public SkyManagerController(SkyManagerRepository managersRepository) {
        this.managersRepository = managersRepository;
    }

    @GetMapping("/managers")
    public String managersView(Map<String, Object> model) {
        Iterable<SkyManager> managers = managersRepository.findAll();
        model.put("managers", managers);
        return "managers";
    }

    @PostMapping("/managers")
    public String addManager(@AuthenticationPrincipal Users user,
                             @RequestParam String firstName,
                             @RequestParam String lastName,
                             @RequestParam(required = false) String email,
                             @RequestParam(required = false, defaultValue = "+7(000)-000-00-00") String phoneNumber
                             ) {
        SkyManager manager = new SkyManager();
        manager.setFirstName(firstName);
        manager.setLastName(lastName);
        manager.setEmail(email);
        manager.setPhoneNumber(phoneNumber);
        manager.setAuthor(user);
        managersRepository.save(manager);
        return "redirect:/managers";
    }

    @PostMapping("/managersFilter")
    public String findCourier(@RequestParam(required = false) Integer managerId,
                              @RequestParam(required = false) String firstName,
                              @RequestParam(required = false) String lastName,
                              Map<String, Object> model) {
        Iterable<SkyManager> managers;
        if (managerId != null & firstName.isEmpty() & lastName.isEmpty()) {
            managers = managersRepository.findByManagerId(managerId);
        } else if (managerId == null & !firstName.isEmpty() & !lastName.isEmpty()) {
            managers = managersRepository.findByFirstNameAndLastName(firstName, lastName);
        } else if (managerId == null & !firstName.isEmpty() & lastName.isEmpty()) {
            managers = managersRepository.findByFirstName(firstName);
        } else if (managerId != null & !firstName.isEmpty() & lastName.isEmpty()) {
            managers = managersRepository.findByManagerIdAndFirstName(managerId, firstName);
        } else if (managerId != null & firstName.isEmpty() & !lastName.isEmpty()) {
            managers = managersRepository.findByManagerIdAndLastName(managerId, lastName);
        } else if (managerId == null & firstName.isEmpty() & !lastName.isEmpty()) {
            managers = managersRepository.findByLastName(lastName);
        } else if (managerId != null & !firstName.isEmpty() & !lastName.isEmpty()) {
            managers = managersRepository.findByManagerIdAndFirstNameAndLastName(managerId, firstName, lastName);
        } else {
            managers = managersRepository.findAll();
        }
        if (!managers.iterator().hasNext()) {
            model.put("filterCheck", "No manager with such index!");
            return "managers";
        } else {
            model.put("managers", managers);
        }
        return "managers";
    }

    @Transactional
    @PostMapping("/managersDelete")
    public String deleteManager(@RequestParam Integer managerId, Map<String, Object> model) {
        List<SkyManager> manager = managersRepository.findByManagerId(managerId);
        if (manager.isEmpty()) {
            model.put("deleteIdCheck", "No manager with such index!");
            return "managers";
        } else {
            managersRepository.deleteByManagerId(managerId);
        }
        return "redirect:/managers";
    }

    @Transactional
    @PostMapping("/managersUpdate")
    public String updateCourier(@RequestParam Integer managerId,
                                @RequestParam(required = false) String firstName,
                                @RequestParam(required = false) String lastName,
                                @RequestParam(required = false) String email,
                                @RequestParam(required = false) String phoneNumber,
                                Map<String, Object> model) {
        List<SkyManager> manager = managersRepository.findByManagerId(managerId);
        if (manager.isEmpty()) {
            model.put("updateIdCheck", "Manager with such index does not exist!");
            return "managers";
        } else {
            if (!firstName.isEmpty()) {
                managersRepository.setFirstNameFor(firstName, managerId);
            }
            if (!lastName.isEmpty()) {
                managersRepository.setLastNameFor(lastName, managerId);
            }
            if (!email.isEmpty()) {
                managersRepository.setEmailFor(email, managerId);
            }
            if (!phoneNumber.isEmpty()) {
                managersRepository.setPhoneNumberFor(phoneNumber, managerId);
            }
        }
        return "redirect:/managers";
    }
}
