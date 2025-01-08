package com.example.gym.service;

import com.example.gym.entity.Membre;
import com.example.gym.repository.MembreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MembreService {
    
    @Autowired
    private MembreRepository membreRepository;
    
    public List<Membre> getAllMembres() {
        return membreRepository.findAll();
    }
    
    public Membre getMembre(Long id) {
        return membreRepository.findById(id).orElse(null);
    }
    
    public Membre saveMembre(Membre membre) {
        return membreRepository.save(membre);
    }
    
    public void deleteMembre(Long id) {
        membreRepository.deleteById(id);
    }
}