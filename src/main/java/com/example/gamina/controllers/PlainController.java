package com.example.gamina.controllers;

import com.example.gamina.repositories.PlainRepository;
import com.example.gamina.tableObjects.Plain;
import com.example.gamina.tableObjects.SkyManager;
import com.example.gamina.tableObjects.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
public class PlainController {

    private PlainRepository plainRepository;

    @Autowired
    public PlainController(PlainRepository plainRepository) {

        this.plainRepository=plainRepository;
    }
    @GetMapping("/plains")
    public String plainsView(Map<String, Object> model) {
        Plain plain = new Plain();
        try {
            String link = "http://192.168.1.54:8080/data.json";
            URL url = new URL(link);
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(url.openStream()));
            String inputLine;
            String line="";
            String l1="[]";
            while ((inputLine = in.readLine()) != null){
                line=line + inputLine;
            }
                if(line.equals(l1)){
                    Iterable<Plain> plains = plainRepository.findAll();
                    model.put("plains", plains);
                }
                else{
                String[]lines=line.split(",");
                ArrayList<String> plainEnt=new ArrayList<String>();
                for(String info : lines) {
                    String[] l = info.split(":");
                        String s = l[1].replaceAll("[^A-Za-zА-Яа-я0-9-.]", "").trim();
                        plainEnt.add(s);
                        if (plainEnt.size()==7){
                            for (int i = 0; i < 1; i++) {
                            plain.setHexId(plainEnt.get(i));
                            if(plainEnt.get(i + 1)==null) {
                                plain.setFlight("0");
                            }
                            else {
                            plain.setFlight(plainEnt.get(i + 1));
                            }
                            plain.setLatitude(plainEnt.get(i + 2));
                            plain.setLongitude(plainEnt.get(i + 3));
                            plain.setAltitude(plainEnt.get(i + 4));
                            if(plainEnt.get(i + 5)==null) {
                                    plain.setTrack("0");
                            }
                            else {
                            plain.setTrack(plainEnt.get(i + 5));
                            }
                            if(plainEnt.get(i + 6)==null) {
                                    plain.setSpeed("0");
                            }
                            else {
                                plain.setSpeed(plainEnt.get(i + 6));
                            }
                            plainRepository.save(plain);
                        }
                        }
                    }
                    in.close();
                    Iterable<Plain> plains = plainRepository.findAll();
                    model.put("plains", plains);

                }
        }
        catch (IOException ex){
            System.out.println("Interruption");
        }
        return "plains";
    }

    @Transactional
    @PostMapping("/plainsDelete")
    public String deletePlain(@RequestParam Integer plainId, Map<String, Object> model) {
        List<Plain> plain = plainRepository.findByPlainId(plainId);
        if (plain.isEmpty()) {
            model.put("deleteIdCheck", "No plain with such index!");
            return "plains";
        } else {
            plainRepository.deleteByPlainId(plainId);
        }
        return "redirect:/plains";
    }

    @Transactional
    @PostMapping("/plainsUpdate")
    public String updatePlain(@RequestParam Integer plainId,
                                @RequestParam(required = false) String hexId,
                                @RequestParam(required = false) String flight,
                                @RequestParam(required = false) String altitude,
                                @RequestParam(required = false) String speed,
                                @RequestParam(required = false) String latitude,
                                @RequestParam(required = false) String longitude,
                                @RequestParam(required = false) String track,
                                Map<String, Object> model) {
        List<Plain> plain = plainRepository.findByPlainId(plainId);
        if (plain.isEmpty()) {
            model.put("updateIdCheck", "Plain with such index does not exist!");
            return "plains";
        } else {
            if (!hexId.isEmpty()) {
                plainRepository.setHexIdFor(hexId, plainId);
            }
            if (!flight.isEmpty()) {
                plainRepository.setFlightFor(flight, plainId);
            }
            if (!altitude.isEmpty()) {
                plainRepository.setAltitudeFor(altitude, plainId);
            }
            if (!speed.isEmpty()) {
                plainRepository.setSpeedFor(speed, plainId);
            }
            if (!latitude.isEmpty()) {
                plainRepository.setLatitudeFor(latitude, plainId);
            }
            if (!longitude.isEmpty()) {
                plainRepository.setLongitudeFor(longitude, plainId);
            }
            if (!track.isEmpty()) {
                plainRepository.setTrackFor(track, plainId);
            }
        }
        return "redirect:/plains";
    }
    @PostMapping("/plainsFilter")
    public String findPlainAnd(@RequestParam(required = false) Integer plainId,
                              @RequestParam(required = false) String HexId,
                              @RequestParam(required = false) String flight,
                              Map<String, Object> model) {
        Iterable<Plain> plains;
        if (plainId != null & HexId.isEmpty() & flight.isEmpty()) {
            plains = plainRepository.findByPlainId(plainId);
        } else if (plainId == null & !HexId.isEmpty() & flight.isEmpty()) {
            plains = plainRepository.findByHexId(HexId);
        } else if (plainId == null & HexId.isEmpty() & !flight.isEmpty()) {
            plains = plainRepository.findByFlight(flight);
        } else {
            plains = plainRepository.findAll();
        }
        if (!plains.iterator().hasNext()) {
            model.put("filterCheck", "No plains with such parametres!");
            return "plains";
        } else {
            model.put("plains", plains);
        }
        return "plains";
    }
}