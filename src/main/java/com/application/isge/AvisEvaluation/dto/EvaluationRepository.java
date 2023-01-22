package com.application.isge.AvisEvaluation.dto;

import com.application.isge.AvisEvaluation.model.Evaluation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EvaluationRepository extends JpaRepository<Evaluation, Long>{

}
