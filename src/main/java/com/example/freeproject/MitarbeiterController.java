package com.example.freeproject;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class MitarbeiterController {
    private MitarbeiterRepository mitarbeiterRepository;

    public MitarbeiterController(MitarbeiterRepository mitarbeiterRepository){
        this.mitarbeiterRepository = mitarbeiterRepository;
    }

    @GetMapping("/mitarbeiter")
        public List<Mitarbeiter> getAllMitarbeiter(){
        return mitarbeiterRepository.findAll();
        }
    @GetMapping("/hallo/{mitarbeiterID}")
    public String greet(@PathVariable int mitarbeiterID) {
        Mitarbeiter mitarbeiter = mitarbeiterRepository.findByMitarbeiterID(mitarbeiterID);
        if (mitarbeiter != null) {
            return "Hallo " + mitarbeiter.getName();
        } else {
            return "Mitarbeiter mit der ID " + mitarbeiterID + " nicht gefunden";
        }
    }

    @PostMapping("/moin")
    public String moin(@RequestParam String name){
        return "Moin " + name + "!";
    }

    @DeleteMapping("/remove/{mitarbeiterID}")
    public String fireWorker(@PathVariable int mitarbeiterID) {
        Mitarbeiter mitarbeiter = mitarbeiterRepository.findByMitarbeiterID(mitarbeiterID);
        if (mitarbeiter != null) {
            mitarbeiterRepository.deleteById((mitarbeiter.getId()));
            return "Mitarbeiter " + mitarbeiter.getName() + " wurde gefeuert!";
        } else {
            return "Mitarbeiter mit der ID: " + mitarbeiterID + " nicht gefunden!";
        }
    }
}
