package com.example.gym.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Membre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idMembre;
    private String nom;
    private String prenom;
    private String email;
    
    @Enumerated(EnumType.STRING)
    private Statut statut;
}