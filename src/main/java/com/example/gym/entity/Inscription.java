package com.example.gym.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Data
@Entity
@Table(uniqueConstraints = {
    @UniqueConstraint(columnNames = {"membre_id", "seance_id"})
})
public class Inscription {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private LocalDateTime dateInscription;
    
    @ManyToOne
    @JoinColumn(name = "membre_id", nullable = false)
    private Membre membre;
    
    @ManyToOne
    @JoinColumn(name = "seance_id", nullable = false)
    private Seance seance;
    
    @PrePersist
    protected void onCreate() {
        dateInscription = LocalDateTime.now();
    }
}