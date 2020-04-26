package com.example.gamina.controllers;

import com.example.gamina.repositories.PlainRepository;

import com.example.gamina.service.PlainListService;

import com.example.gamina.tableObjects.Plain;
import com.example.gamina.tableObjects.PlainList;

import com.example.gamina.tableObjects.SkyManager;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
public class PlainController {

    private PlainRepository plainRepository;
    private PlainListService plainListService;
    @Autowired
    public PlainController(PlainRepository plainRepository, PlainListService plainListService) {

        this.plainRepository=plainRepository;
        this.plainListService=plainListService;
    }

    @GetMapping("/plains")
    public String plainsView(Map<String, Object> model) {
        Plain plain=new Plain();
        List<PlainList>plainsServ=plainListService.getAllPlains();
        for(PlainList p:plainsServ){
            if (plainRepository.findByHexId(p.getHexId()).isEmpty()){
                plain.setHexId(p.getHexId());
                plain.setSpeed(p.getSpeed());
                plain.setLongitude(p.getLongitude());
                plain.setLatitude(p.getLatitude());
                plain.setAltitude(p.getAltitude());
                plain.setFlight(p.getFlight());
                plain.setTrack(p.getTrack());
                plainRepository.save(plain);
            }
        }
        Iterable<Plain> plains=plainRepository.findAll();
        model.put("plains",plains);
        return "plains";
    }
    @GetMapping("/plainsCur")
    public String plainsGet(Map<String, Object> model) {
        List<PlainList>plainsCur=plainListService.getAllPlains();
        model.put("plainsCur",plainsCur);
        return "plainsCur";
    }

    @Transactional
    @PostMapping("/plainsDelete")
    public String deletePlain(@RequestParam String hexId, Map<String, Object> model) {
        List<Plain> plain = plainRepository.findByHexId(hexId);
        if (plain.isEmpty()) {
            model.put("deleteIdCheck", "No plain with such index!");
            return "plains";
        } else {
            plainRepository.deleteByHexId(hexId);
        }
        return "redirect:/plains";
    }
    @PostMapping("/plainsFilter")
    public String findPlain(//@RequestParam(required = false) Integer plainId,
                              @RequestParam(required = false) String hexId,
                              @RequestParam(required = false) String flight,
                              Map<String, Object> model) {
        Iterable<Plain> plains;
        if (!hexId.isEmpty() & flight.isEmpty()) {
            plains=plainRepository.findByHexId(hexId);
        } else if (hexId.isEmpty() & !flight.isEmpty()) {
            plains=plainRepository.findByFlight(flight);
        } else {
            plains = plainRepository.findAll();
        }
        if (!plains.iterator().hasNext()) {
            model.put("filterCheck", "No plain with such index!");
            return "plains";
        } else {
            model.put("plains", plains);
        }
        return "plains";
    }
   @Transactional
    @PostMapping("/plainsUpdate")
    public String updatePlain(@RequestParam String hexId,
                                @RequestParam(required = false) String flight,
                                @RequestParam(required = false) String altitude,
                                @RequestParam(required = false) String speed,
                                @RequestParam(required = false) String latitude,
                                @RequestParam(required = false) String longitude,
                                @RequestParam(required = false) String track,
                                Map<String, Object> model) {
        List<Plain> plain = plainRepository.findByHexId(hexId);
        if (plain.isEmpty()) {
            model.put("updateIdCheck", "Plain with such index does not exist!");
            return "plains";
        } else {
            if (!flight.isEmpty()) {
                plainRepository.setFlightF(flight, hexId);
            }
            if (!altitude.isEmpty()) {
                plainRepository.setAltitudeF(altitude, hexId);
            }
            if (!speed.isEmpty()) {
                plainRepository.setSpeedF(speed, hexId);
            }
            if (!latitude.isEmpty()) {
                plainRepository.setLatitudeF(latitude, hexId);
            }
            if (!longitude.isEmpty()) {
                plainRepository.setLongitudeF(longitude, hexId);
            }
            if (!track.isEmpty()) {
                plainRepository.setTrackF(track, hexId);
            }
        }
        return "redirect:/plains";
    }
   /** @PostMapping("/plainsFilt")
    public String findPlain(@RequestParam(required = false)String HexId,
                              @RequestParam(required = false) String flight,
                              Map<String, Object> model) {
        System.out.println(HexId);
        System.out.println(flight);
        List<PlainList>plains =new ArrayList<>();
        if (!HexId.isEmpty() & flight.isEmpty()) {
            plains = plainListService.searchByHexId(HexId);
        } else if (HexId.isEmpty() & !flight.isEmpty()) {
            plains = plainListService.searchByFlight(flight);
        }
        else {
            plains = plainListService.getAllPlains();
        }
        if (plains.isEmpty()) {
            model.put("filterCheck", "No plains with such parametres!");
            return "plains";
        } else {
            model.put("plains", plains);
        }
        return "plains";
    }
**/

}