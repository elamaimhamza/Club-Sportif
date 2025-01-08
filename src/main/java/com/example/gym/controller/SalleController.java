package com.example.gym.controller;

import com.example.gym.entity.Salle;
import com.example.gym.service.SalleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/salles")
public class SalleController {
    @Autowired
    private SalleService salleService;

    @GetMapping
    public String listSalles(Model model) {
        model.addAttribute("salles", salleService.getAllSalles());
        return "salles/list";
    }

    @GetMapping("/new")
    public String showCreateForm(Model model) {
        model.addAttribute("salle", new Salle());
        return "salles/form";
    }

    @PostMapping
    public String saveSalle(@ModelAttribute Salle salle) {
        salleService.saveSalle(salle);
        return "redirect:/salles";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        model.addAttribute("salle", salleService.getSalle(id));
        return "salles/form";
    }

    @GetMapping("/delete/{id}")
    public String deleteSalle(@PathVariable Long id) {
        salleService.deleteSalle(id);
        return "redirect:/salles";
    }
}