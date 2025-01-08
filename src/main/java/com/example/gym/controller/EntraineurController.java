package com.example.gym.controller;

import com.example.gym.entity.Entraineur;
import com.example.gym.service.EntraineurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/entraineurs")
public class EntraineurController {
    @Autowired
    private EntraineurService entraineurService;

    @GetMapping
    public String listEntraineurs(Model model) {
        model.addAttribute("entraineurs", entraineurService.getAllEntraineurs());
        return "entraineurs/list";
    }

    @GetMapping("/new")
    public String showCreateForm(Model model) {
        model.addAttribute("entraineur", new Entraineur());
        return "entraineurs/form";
    }

    @PostMapping
    public String saveEntraineur(@ModelAttribute Entraineur entraineur) {
        entraineurService.saveEntraineur(entraineur);
        return "redirect:/entraineurs";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        model.addAttribute("entraineur", entraineurService.getEntraineur(id));
        return "entraineurs/form";
    }

    @GetMapping("/delete/{id}")
    public String deleteEntraineur(@PathVariable Long id) {
        entraineurService.deleteEntraineur(id);
        return "redirect:/entraineurs";
    }
}