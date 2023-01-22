package com.application.isge.AvisEvaluation.model;


import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;

@Data
@Entity
public class Avis implements Serializable {
    @Id
    @GeneratedValue
    private Long avis_id;
    private String nom;



}
