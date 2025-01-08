package com.example.gym.repository;

import com.example.gym.entity.Seance;
import org.springframework.data.jpa.repository.JpaRepository;
import java.time.LocalDate;
import java.util.List;

public interface SeanceRepository extends JpaRepository<Seance, Long> {
    List<Seance> findByDate(LocalDate date);
}