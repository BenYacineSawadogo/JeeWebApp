package com.application.isge.AvisEvaluation.dto;

import com.application.isge.AvisEvaluation.model.Evaluation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EvaluationRepository extends JpaRepository<Evaluation, Long>{
    @Query("SELECT e FROM Evaluation e WHERE e.avis_id= :avisId AND e.critere_id= :critereId AND e.evaluationId= :evaluationId")
    List <Evaluation> findEvaluationsByAvisIdAndAndCritereIdAndEvaluationId(Long avisId,Long critereId,Long evaluationId);

}
