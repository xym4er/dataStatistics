package com.ri4.dataStatistics.controllers;

import com.ri4.dataStatistics.domain.Pilot;
import com.ri4.dataStatistics.repos.PilotsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.Map;

@Controller
public class MainController {

    @Autowired
    private PilotsRepo pilotsRepo;

    @GetMapping("/addpilots")
    public String addPilots(){
        Pilot pilot = new Pilot();
        pilot.setName("Valenok");
        pilot.setMain(true);
        pilotsRepo.save(pilot);
        Pilot pilot1 = new Pilot();
        pilot1.setName("Pelmen");
        pilot1.setMain(true);
        pilotsRepo.save(pilot1);
        Pilot pilot2 = new Pilot();
        pilot2.setName("Kirpich");
        pilot2.setMain(true);
        pilotsRepo.save(pilot2);
        Pilot pilot3 = new Pilot();
        pilot3.setName("PelmenTabyret");
        pilot3.setMain(true);
        pilotsRepo.save(pilot3);

        return "Pilots added";
    }

    @GetMapping("/pilots")
    public String pilots() {


        List<Pilot> pilots = pilotsRepo.findAll();


        return "Find "+pilots.size()+"pilots";
    }
}
