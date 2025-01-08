package com.example.gym.entity;

import jakarta.persistence.*;
import java.util.List;
import lombok.Data;

@Data
@Entity
public class Cours {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCours;
    
    @Column(unique = true)
    private String nom;
    
    @ManyToOne
    @JoinColumn(name = "entraineur_id", nullable = false)
    private Entraineur entraineur;
    
    @ManyToOne
    @JoinColumn(name = "salle_id", nullable = false)
    private Salle salle;
    
    @OneToMany(mappedBy = "cours")
    private List<Seance> seances;
}