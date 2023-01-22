package com.application.isge.AvisEvaluation.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Generated;

import java.util.List;

@Data
@Entity
public class Critere {
    @Id
    @GeneratedValue
    private Long id;
    private String nom;
    private int note;
    @OneToMany
    private List<Evaluation> evaluation;
}
