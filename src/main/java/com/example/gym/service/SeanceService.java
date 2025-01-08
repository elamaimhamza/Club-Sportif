package com.example.gym.service;

import com.example.gym.entity.Seance;
import com.example.gym.repository.SeanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class SeanceService {
    @Autowired
    private SeanceRepository seanceRepository;

    public List<Seance> getAllSeances() {
        return seanceRepository.findAll();
    }

    public Seance getSeance(Long id) {
        return seanceRepository.findById(id).orElse(null);
    }

    public Seance saveSeance(Seance seance) {
        return seanceRepository.save(seance);
    }

    public void deleteSeance(Long id) {
        seanceRepository.deleteById(id);
    }
}