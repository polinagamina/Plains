package com.example.gamina.service;

import com.example.gamina.tableObjects.PlainList;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class PlainListService {
    private List<PlainList> allPlains = new ArrayList<>();
    private HashMap<String,PlainList> findPlain = new HashMap<>();
    private HashMap<String,PlainList> fPlain = new HashMap<>();
    private static String link = "http://192.168.1.54:8080/data.json";
    private String check;

    public List<PlainList> getAllPlains() {
        return allPlains;
    }

    @PostConstruct
    @Scheduled(cron = "* * * * * *")
    public void getPlanes() throws IOException {
        List<PlainList> newPlains = new ArrayList<>();
        HashMap<String, PlainList> plainMap = new HashMap<>();
        HashMap<String, PlainList> searchMap = new HashMap<>();
        //Plain plainBd = new Plain();
        PlainList plain = new PlainList();
        String link = "http://192.168.1.54:8080/data.json";
        URL url = new URL(link);
        BufferedReader in = new BufferedReader(
                new InputStreamReader(url.openStream()));
        String inputLine;
        String line = "";
        String l1 = "[]";
        while ((inputLine = in.readLine()) != null) {
            line = line + inputLine;
        }

        if (!line.equals(l1)) {
            String[] lines = line.split(",");
            ArrayList<String> plainEnt = new ArrayList<String>();
            for (String info : lines) {
                String[] l = info.split(":");
                String s = l[1].replaceAll("[^A-Za-zА-Яа-я0-9-.]", "").trim();
                plainEnt.add(s);
                if (plainEnt.size() == 7) {
                    for (int i = 0; i < 1; i++) {
                        plain.setHexId(plainEnt.get(i));
                        if (plainEnt.get(i + 1) == null) {
                            plain.setFlight("0");
                        } else {
                            plain.setFlight(plainEnt.get(i + 1));
                        }
                        plain.setLatitude(plainEnt.get(i + 2));
                        plain.setLongitude(plainEnt.get(i + 3));
                        plain.setAltitude(plainEnt.get(i + 4));
                        if (plainEnt.get(i + 5) == null) {
                            plain.setTrack("0");
                        } else {
                            plain.setTrack(plainEnt.get(i + 5));
                        }
                        if (plainEnt.get(i + 6) == null) {
                            plain.setSpeed("0");
                        } else {
                            plain.setSpeed(plainEnt.get(i + 6));
                        }

                        plainMap.put(plain.getHexId(), plain);
                        searchMap.put(plain.getFlight(),plain);
                        this.findPlain=plainMap;
                        this.fPlain=searchMap;

                        for (Map.Entry<String, PlainList> p : plainMap.entrySet()) {
                            newPlains.add(p.getValue());
                        }
                        this.allPlains = newPlains;
                    }
                }
            }

        }else {
            this.allPlains=newPlains;
        }
    }
    public List<PlainList> searchByHexId(String hexId){
        List<PlainList> searchPlain = new ArrayList<>();
        for (Map.Entry<String, PlainList> p : findPlain.entrySet()){
            if((this.findPlain).containsKey(hexId)){
                searchPlain.add((this.findPlain).get(hexId));
            }
        }
        return searchPlain;
    }
    public List<PlainList> searchByFlight(String flight){
        List<PlainList> searchPlain = new ArrayList<>();
        for (Map.Entry<String, PlainList> p : fPlain.entrySet()){
            if((this.fPlain).containsKey(flight)){
                searchPlain.add((this.fPlain).get(flight));
            }
        }
        return searchPlain;
    }

}

