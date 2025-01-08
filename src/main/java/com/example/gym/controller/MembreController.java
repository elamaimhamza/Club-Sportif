package com.example.gym.controller;

import com.example.gym.entity.Membre;
import com.example.gym.service.MembreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/membres")
public class MembreController {

    @Autowired
    private MembreService membreService;

    @GetMapping
    public String listMembres(Model model) {
        model.addAttribute("membres", membreService.getAllMembres());
        return "membres/list";
    }

    @GetMapping("/new")
    public String showCreateForm(Model model) {
        model.addAttribute("membre", new Membre());
        return "membres/form";
    }

    @PostMapping
    public String saveMembre(@ModelAttribute Membre membre) {
        membreService.saveMembre(membre);
        return "redirect:/membres";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        model.addAttribute("membre", membreService.getMembre(id));
        return "membres/form";
    }

    @GetMapping("/delete/{id}")
    public String deleteMembre(@PathVariable Long id) {
        membreService.deleteMembre(id);
        return "redirect:/membres";
    }
}