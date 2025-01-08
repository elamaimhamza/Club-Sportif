package com.example.gym.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Salle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idSalle;
    
    @Column(unique = true)
    private String nom;
    
    private int capacite;
}