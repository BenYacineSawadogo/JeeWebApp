package com.application.isge.AvisEvaluation.controller;

import com.application.isge.AvisEvaluation.dto.EvaluationRepository;
import com.application.isge.AvisEvaluation.model.Evaluation;
import com.application.isge.AvisEvaluation.service.EvaluationService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EvaluationController {
    @Autowired
    private EvaluationService evaluationService;
    private final EvaluationRepository evaluationRepository;

    public EvaluationController(EvaluationRepository evaluationRepository) {
        this.evaluationRepository = evaluationRepository;
    }

    @PostMapping("/createEvaluation")
    public Evaluation createEvaluation(@RequestBody Evaluation evaluation){
        return  evaluationService.createEvaluation(evaluation);
    }
    @GetMapping("/evaluation/{id}")
    public  Evaluation getEvaluationById(@PathVariable long id){
        return  evaluationService.getEvaluataionByd(id);
    }

    @GetMapping("/evaluations")
    public  List <Evaluation> getEvaluations(){
        return evaluationService.getEvaluations();
    }

    @PutMapping("/evaluation/updateEvaluation")
    public Evaluation updateEvaluation(@RequestBody Evaluation evaluation){
        return  evaluationService.UpdateEvaluation(evaluation);

    }
    public  String deleteEvaluation(@PathVariable long id){
        evaluationService.deleteById(id);
        return "Deleted Successfully";
    }
}
