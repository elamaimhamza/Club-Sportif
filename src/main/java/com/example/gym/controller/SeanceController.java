package com.example.gym.controller;

import com.example.gym.entity.Seance;
import com.example.gym.service.SeanceService;
import com.example.gym.service.CoursService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/seances")
public class SeanceController {
    @Autowired
    private SeanceService seanceService;
    
    @Autowired
    private CoursService coursService;

    @GetMapping
    public String listSeances(Model model) {
        model.addAttribute("seances", seanceService.getAllSeances());
        return "seances/list";
    }

    @GetMapping("/new")
    public String showCreateForm(Model model) {
        model.addAttribute("seance", new Seance());
        model.addAttribute("cours", coursService.getAllCours());
        return "seances/form";
    }

    @PostMapping
    public String saveSeance(@ModelAttribute Seance seance) {
        seanceService.saveSeance(seance);
        return "redirect:/seances";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        model.addAttribute("seance", seanceService.getSeance(id));
        model.addAttribute("cours", coursService.getAllCours());
        return "seances/form";
    }

    @GetMapping("/delete/{id}")
    public String deleteSeance(@PathVariable Long id) {
        seanceService.deleteSeance(id);
        return "redirect:/seances";
    }
}