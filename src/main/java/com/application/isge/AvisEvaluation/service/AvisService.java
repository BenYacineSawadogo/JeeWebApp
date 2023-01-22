package com.application.isge.AvisEvaluation.service;

import com.application.isge.AvisEvaluation.dto.AvisRepository;
import com.application.isge.AvisEvaluation.model.Avis;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AvisService {
    @Autowired
    private AvisRepository avisRepository;

    public Avis createAvis(Avis avis){
        return avisRepository.save(avis);
    }

    public Avis getAvisByd(long id){
        return avisRepository.findById(id).orElse(null);
    }

    public List<Avis> getAvis(){
        return avisRepository.findAll();
    }

    public Avis UpdateAvis(Avis avis){
        Avis oldEvaluation;
        Optional<Avis> optionalEvaluation = avisRepository.findById(avis.getAvis_id());
        if(optionalEvaluation.isPresent()){
            oldEvaluation = optionalEvaluation.get();
            oldEvaluation.setNom(avis.getNom());
            avisRepository.save(oldEvaluation);
        }else {
            return  new Avis();
        }
        return oldEvaluation;
    }

    public  String deleteById(long id){
        avisRepository.deleteById(id);
        return "Deleted successfully";
    }
/*
    public double calculateAverageScore(Evaluation evaluation) {
        double totalScore = evaluation.getCritere().stream()
                .mapToDouble(Critere::getNote)
                .sum();
        return totalScore / evaluation.getCritere().;

public double calculateAverageScore(Avis evaluation) {
    List<Critere> criteriaList = (List<Critere>) evaluation.getCritere();
    double totalScore = 0;
    for (Critere criteria : criteriaList) {
        totalScore += criteria.getNote();
    }
    return totalScore / criteriaList.size();
}*

 */

}
