package com.application.isge.AvisEvaluation.service;

import com.application.isge.AvisEvaluation.dto.EvaluationRepository;
import com.application.isge.AvisEvaluation.model.Critere;
import com.application.isge.AvisEvaluation.model.Evaluation;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EvaluationService {
    private EvaluationRepository evaluationRepository;

    public Evaluation createEvaluation(Evaluation evaluation){
        return evaluationRepository.save(evaluation);
    }

    public Evaluation getEvaluataionByd(long id){
        return evaluationRepository.findById(id).orElse(null);
    }

    public List<Evaluation> getEvaluations(){
        return evaluationRepository.findAll();
    }

    public Evaluation UpdateEvaluation(Evaluation evaluation){
        Evaluation oldEvaluation;
        Optional<Evaluation> optionalEvaluation = evaluationRepository.findById(evaluation.getId());
        if(optionalEvaluation.isPresent()){
            oldEvaluation = optionalEvaluation.get();
            oldEvaluation.setNom(evaluation.getNom());
            oldEvaluation.setCritere(evaluation.getCritere());
            evaluationRepository.save(oldEvaluation);
        }else {
            return  new Evaluation();
        }
        return oldEvaluation;
    }

    public  String deleteById(long id){
        evaluationRepository.deleteById(id);
        return "Deleted successfully";
    }
/*
    public double calculateAverageScore(Evaluation evaluation) {
        double totalScore = evaluation.getCritere().stream()
                .mapToDouble(Critere::getNote)
                .sum();
        return totalScore / evaluation.getCritere().;
    }*/
public double calculateAverageScore(Evaluation evaluation) {
    List<Critere> criteriaList = (List<Critere>) evaluation.getCritere();
    double totalScore = 0;
    for (Critere criteria : criteriaList) {
        totalScore += criteria.getNote();
    }
    return totalScore / criteriaList.size();
}

}
