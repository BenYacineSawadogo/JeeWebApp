package com.application.isge.AvisEvaluation.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Evaluation {
    @Id
    @GeneratedValue
    private long evaluationId;

    @Column(name = "avis_id" )
    private long avis_id;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "avis_id",referencedColumnName = "avis_id", insertable = false,updatable = false)
    private Avis avis;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "critere_id",referencedColumnName = "critere_id", insertable = false,updatable = false)
    private Critere critere;

    @Column(name ="critere_id" )
    private long critere_id;
    private int note;

}
