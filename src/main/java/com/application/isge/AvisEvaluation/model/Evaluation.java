package com.application.isge.AvisEvaluation.model;


import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Evaluation {
    @Id
    private Long id;
    private String nom;
    @ManyToOne
    @JoinColumn(name = "critere_id")
    private Critere critere;

}
