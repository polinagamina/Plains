package com.example.gamina.controllers;

import com.example.gamina.repositories.PlainRepository;
import com.example.gamina.tableObjects.Plain;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
                    plain.setHexId("0");
                    plain.setFlight("0");
                    plain.setLatitude("0");
                    plain.setLongitude("0");
                    plain.setAltitude("0");
                    plain.setTrack("0");
                    plain.setSpeed("0");
                    plainRepository.save(plain);
                }
                else{
                String[]lines=line.split(",");
                ArrayList<String> plainEnt=new ArrayList<String>();
                for(String info : lines) {
                    String[] l = info.split(":");
                        String s = l[1].replaceAll("[^A-Za-zА-Яа-я0-9-.]", "").trim();
                        plainEnt.add(s);
                        for (int i = 0; i < 1; i++) {
                            plain.setHexId(plainEnt.get(i));
                            plain.setFlight(plainEnt.get(i + 1));
                            plain.setLatitude(plainEnt.get(i + 2));
                            plain.setLongitude(plainEnt.get(i + 3));
                            plain.setAltitude(plainEnt.get(i + 4));
                            plain.setTrack(plainEnt.get(i + 5));
                            plain.setSpeed(plainEnt.get(i + 6));
                            plainRepository.save(plain);
                        }
                    }
                }
            in.close();
        }
        catch (IOException ex){
            System.out.println("Interruption");
        }
        Iterable<Plain> plains = plainRepository.findAll();
        model.put("plains", plains);
        return "plains";
    }
   /** @PostMapping("/plains")
    public String addNewPlain() {

        return "redirect:/plains";
    }**/

}