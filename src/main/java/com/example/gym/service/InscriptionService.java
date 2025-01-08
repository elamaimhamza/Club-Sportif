package com.example.gym.service;

import com.example.gym.entity.Inscription;
import com.example.gym.entity.Membre;
import com.example.gym.entity.Seance;
import com.example.gym.repository.InscriptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InscriptionService {
    
    @Autowired
    private InscriptionRepository inscriptionRepository;
    
    public boolean inscrireMembre(Membre membre, Seance seance) {
        // Vérifier si le membre est déjà inscrit
        if (inscriptionRepository.existsByMembreAndSeance(membre, seance)) {
            return false;
        }
        
        // Vérifier la capacité de la séance
        int nombreInscrits = inscriptionRepository.countBySeance(seance);
        if (nombreInscrits >= seance.getCapaciteMax()) {
            return false;
        }
        
        // Créer l'inscription
        Inscription inscription = new Inscription();
        inscription.setMembre(membre);
        inscription.setSeance(seance);
        inscriptionRepository.save(inscription);
        
        return true;
    }
}