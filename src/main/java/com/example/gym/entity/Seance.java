package com.example.gym.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Data
@Entity
public class Seance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idSeance;
    
    private LocalDate date;
    private LocalTime heure;
    private int capaciteMax;
    
    @ManyToOne
    @JoinColumn(name = "cours_id", nullable = false)
    private Cours cours;
    
    @OneToMany(mappedBy = "seance")
    private List<Inscription> inscriptions;
}