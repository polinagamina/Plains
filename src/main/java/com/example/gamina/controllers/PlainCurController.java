package com.example.gamina.controllers;

import com.example.gamina.repositories.PlainRepository;
import com.example.gamina.service.PlainListService;
import com.example.gamina.tableObjects.Plain;
import com.example.gamina.tableObjects.PlainList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
public class PlainCurController {
    private PlainRepository plainRepository;
    private PlainListService plainListService;
    @Autowired
    public PlainCurController(PlainRepository plainRepository, PlainListService plainListService) {

        this.plainRepository=plainRepository;
        this.plainListService=plainListService;
    }
    @GetMapping("/plainsCur")
    public String plainsGet(Map<String, Object> model) {
        List<PlainList> plainsCur=plainListService.getAllPlains();
        model.put("plainsCur",plainsCur);
        return "plainsCur";
    }
    @PostMapping("/plainsCurFilter")
    public String findPlain(//@RequestParam(required = false) Integer plainId,
                            @RequestParam(required = false) String hexId,
                            @RequestParam(required = false) String flight,
                            Map<String, Object> model) {
        List<PlainList>plains =new ArrayList<>();
        if (!hexId.isEmpty() & flight.isEmpty()) {
            plains = plainListService.searchByHexId(hexId);
        } else if (hexId.isEmpty() & !flight.isEmpty()) {
            plains = plainListService.searchByFlight(flight);
        }
        else {
            plains = plainListService.getAllPlains();
        }
        if (plains.isEmpty()) {
            model.put("filterCheck", "Самолетов с такими параметрами нет!");
            model.put("plainsCur", plains);
            return "plainsCur";
        } else {
            model.put("plainsCur", plains);
        }
        return "plainsCur";
    }
}
