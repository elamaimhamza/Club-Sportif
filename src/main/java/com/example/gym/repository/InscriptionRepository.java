package com.example.gym.repository;

import com.example.gym.entity.Inscription;
import com.example.gym.entity.Membre;
import com.example.gym.entity.Seance;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InscriptionRepository extends JpaRepository<Inscription, Long> {
    boolean existsByMembreAndSeance(Membre membre, Seance seance);
    int countBySeance(Seance seance);
}