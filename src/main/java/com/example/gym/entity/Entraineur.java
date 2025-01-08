package com.example.gym.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.util.List;

@Data
@Entity
public class Entraineur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEntraineur;
    
    private String nom;
    private String specialite;
    
    @OneToMany(mappedBy = "entraineur")
    private List<Cours> cours;
}