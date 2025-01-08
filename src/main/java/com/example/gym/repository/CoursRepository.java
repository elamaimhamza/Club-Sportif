package com.example.gym.repository;

import com.example.gym.entity.Cours;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CoursRepository extends JpaRepository<Cours, Long> {
    boolean existsByNom(String nom);
}