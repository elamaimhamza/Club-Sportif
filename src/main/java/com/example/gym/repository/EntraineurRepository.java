package com.example.gym.repository;

import com.example.gym.entity.Entraineur;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EntraineurRepository extends JpaRepository<Entraineur, Long> {
}