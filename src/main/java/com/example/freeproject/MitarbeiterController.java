package com.example.freeproject;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class MitarbeiterController {
    private MitarbeiterRepository mitarbeiterRepository;
    @Autowired
    public MitarbeiterController(MitarbeiterRepository mitarbeiterRepository){
        this.mitarbeiterRepository = mitarbeiterRepository;
    }

    @GetMapping("/mitarbeiter")
        public List<Mitarbeiter> getAllMitarbeiter(){
        return mitarbeiterRepository.findAll();
        }
}
