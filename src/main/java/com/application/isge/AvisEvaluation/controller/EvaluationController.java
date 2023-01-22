package com.application.isge.AvisEvaluation.controller;

import com.application.isge.AvisEvaluation.dto.EvaluationRepository;
import com.application.isge.AvisEvaluation.model.Evaluation;
import com.application.isge.AvisEvaluation.service.EvaluationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EvaluationController {
    @Autowired
    private EvaluationRepository evaluationRepository;
    @Autowired
    private EvaluationService evaluationService;
    @PostMapping("/createEvaluation")
    public Evaluation createEvaluation(@RequestBody Evaluation evaluation){
        return evaluationService.createEvaluation(evaluation);
    }
    @GetMapping("/evaluation/{id}")
    public Evaluation getEvaluationById(@PathVariable long id){
        return  evaluationService.getEvaluationId(id);
    }
    @GetMapping("/evaluations")
    public List<Evaluation> evaluationList(){
        return evaluationService.evaluations();

    }

    @GetMapping("/evaluations/{avisId}/{critereId}/{evaluationId}")
    public List<Evaluation> evaluationList(@PathVariable("critereId") long critereId,@PathVariable("avisId") long avisId ,@PathVariable("evaluationId") long evaluationId){
        return evaluationRepository.findEvaluationsByAvisIdAndAndCritereIdAndEvaluationId(avisId,critereId,evaluationId);

    }
    @PutMapping("/evaluation/upDateEvaluation")
    public Evaluation updateEvalutaion(@RequestBody Evaluation evaluation){
        return evaluationService.updateEvaluation(evaluation);
    }
    @DeleteMapping("/evaluation/deleteEvaluation/{id}")
    public String deleteEvaluation(@PathVariable long id){
        evaluationService.deleteEvaluation(id);
        return "Deleted Successfully";
    }
}
