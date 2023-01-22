package com.application.isge.AvisEvaluation.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Generated;

import java.io.Serializable;
import java.util.List;

@Data
@Entity
public class Critere implements Serializable {
    @Id
    @GeneratedValue
    private Long critere_id;
    private String nom;

    /*@OneToMany
    private List<Evaluation> evaluation;*/
}
