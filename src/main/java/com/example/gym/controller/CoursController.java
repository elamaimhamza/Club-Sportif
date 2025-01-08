package com.example.gym.controller;

import com.example.gym.entity.Cours;
import com.example.gym.service.CoursService;
import com.example.gym.service.EntraineurService;
import com.example.gym.service.SalleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/cours")
public class CoursController {
    @Autowired
    private CoursService coursService;
    
    @Autowired
    private EntraineurService entraineurService;
    
    @Autowired
    private SalleService salleService;

    @GetMapping
    public String listCours(Model model) {
        model.addAttribute("cours", coursService.getAllCours());
        return "cours/list";
    }

    @GetMapping("/new")
    public String showCreateForm(Model model) {
        model.addAttribute("cours", new Cours());
        model.addAttribute("entraineurs", entraineurService.getAllEntraineurs());
        model.addAttribute("salles", salleService.getAllSalles());
        return "cours/form";
    }

    @PostMapping
    public String saveCours(@ModelAttribute Cours cours) {
        coursService.saveCours(cours);
        return "redirect:/cours";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        model.addAttribute("cours", coursService.getCours(id));
        model.addAttribute("entraineurs", entraineurService.getAllEntraineurs());
        model.addAttribute("salles", salleService.getAllSalles());
        return "cours/form";
    }

    @GetMapping("/delete/{id}")
    public String deleteCours(@PathVariable Long id) {
        coursService.deleteCours(id);
        return "redirect:/cours";
    }
}