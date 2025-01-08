package com.example.gym.repository;

import com.example.gym.entity.Salle;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SalleRepository extends JpaRepository<Salle, Long> {
    boolean existsByNom(String nom);
}