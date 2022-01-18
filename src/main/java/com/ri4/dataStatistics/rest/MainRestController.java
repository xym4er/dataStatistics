package com.ri4.dataStatistics.rest;

import com.ri4.dataStatistics.domain.Pilot;
import com.ri4.dataStatistics.repos.PilotsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;
import java.util.Map;

@RestController
public class MainRestController {

    @Autowired
    private PilotsRepo pilotsRepo;

    @GetMapping("/main")
    public String main() {

        return "main";
    }

    @GetMapping("/addpilotsrest")
    public String addPilots(){
        Pilot pilot = new Pilot();
        pilot.setName("Valenok");
        pilot.setMain(true);
        pilotsRepo.save(pilot);

        pilot.setName("Pelmen");
        pilot.setMain(true);
        pilotsRepo.save(pilot);

        pilot.setName("Kirpich");
        pilot.setMain(true);
        pilotsRepo.save(pilot);

        pilot.setName("PelmenTabyret");
        pilot.setMain(true);
        pilotsRepo.save(pilot);

        return "Pilots added";
    }

    @GetMapping("/user")
    public Map<String, Object> user(@AuthenticationPrincipal OAuth2User principal) {
        return Collections.singletonMap("name", principal.getAttribute("name"));
    }

    @GetMapping("/pilotsrest")
    public String pilotsrest() {


        List<Pilot> pilots = pilotsRepo.findAll();


        return "Find "+pilots.size()+"pilots";
    }
}
