package com.application.isge.AvisEvaluation.service;

import com.application.isge.AvisEvaluation.dto.EvaluationRepository;
import com.application.isge.AvisEvaluation.model.Evaluation;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class EvaluationService {
    @Autowired
    private EvaluationRepository evaluationRepository;

    public Evaluation createEvaluation(Evaluation evaluation){
        return evaluationRepository.save(evaluation);
    }
    public Evaluation getEvaluationId(long id){
        return evaluationRepository.findById(id).orElse(null);
    }

    public List<Evaluation> evaluations(){
        return evaluationRepository.findAll();
    }
    public Evaluation updateEvaluation(Evaluation evaluation) {
        Evaluation oldEvaluation;
        Optional<Evaluation> optionalEvaluation = evaluationRepository.findById(evaluation.getEvaluationId());
        if (optionalEvaluation.isPresent()) {
            oldEvaluation = optionalEvaluation.get();
            oldEvaluation.setNote(evaluation.getNote());
        }
        else {
            return  new Evaluation();
        }
        return  oldEvaluation;
    }

    public Double AverageEvaluationByAvisId(Long avisId) {
        return evaluationRepository.findAverageByAvisId(avisId);
    }

    public String deleteEvaluation(long id){
        evaluationRepository.deleteById(id);
        return "deleted successfully";
    }


  /*  public Double AverageEvaluationById(EntityManager em, long id) {
        String jpql = "SELECT AVG(e.note) FROM Evaluation e WHERE e.evaluationId = :id";
        Query query = em.createQuery(jpql);
        query.setParameter("id", id);
        return (Double) query.getSingleResult();
    }*/




}
