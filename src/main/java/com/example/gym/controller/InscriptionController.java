package com.example.gym.controller;

import com.example.gym.entity.Inscription;
import com.example.gym.service.InscriptionService;
import com.example.gym.service.MembreService;
import com.example.gym.service.SeanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/inscriptions")
public class InscriptionController {

    @Autowired
    private InscriptionService inscriptionService;
    
    @Autowired
    private MembreService membreService;
    
    @Autowired
    private SeanceService seanceService;

    @PostMapping("/inscrire")
    public String inscrireMembre(@RequestParam Long membreId, @RequestParam Long seanceId) {
        var membre = membreService.getMembre(membreId);
        var seance = seanceService.getSeance(seanceId);
        
        if (membre != null && seance != null) {
            boolean success = inscriptionService.inscrireMembre(membre, seance);
            if (!success) {
                return "redirect:/seances?error=inscription";
            }
        }
        
        return "redirect:/seances";
    }
}