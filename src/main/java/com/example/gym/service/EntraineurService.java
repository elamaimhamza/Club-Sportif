package com.example.gym.service;

import com.example.gym.entity.Entraineur;
import com.example.gym.repository.EntraineurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class EntraineurService {
    @Autowired
    private EntraineurRepository entraineurRepository;

    public List<Entraineur> getAllEntraineurs() {
        return entraineurRepository.findAll();
    }

    public Entraineur getEntraineur(Long id) {
        return entraineurRepository.findById(id).orElse(null);
    }

    public Entraineur saveEntraineur(Entraineur entraineur) {
        return entraineurRepository.save(entraineur);
    }

    public void deleteEntraineur(Long id) {
        entraineurRepository.deleteById(id);
    }
}