package com.application.isge.AvisEvaluation.controller;

import com.application.isge.AvisEvaluation.dto.AvisRepository;
import com.application.isge.AvisEvaluation.model.Avis;
import com.application.isge.AvisEvaluation.service.AvisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AvisController {
    @Autowired
    private AvisService avisService;
    private final AvisRepository avisRepository;

    public AvisController(AvisRepository avisRepository) {
        this.avisRepository = avisRepository;
    }

    @PostMapping("/createAvis")
    public Avis createEvaluation(@RequestBody Avis evaluation){
        return  avisService.createAvis(evaluation);
    }
    @GetMapping("/avis/{id}")
    public Avis getEvaluationById(@PathVariable long id){
        return  avisService.getAvisByd(id);
    }

    @GetMapping("/avis")
    public  List <Avis> getEvaluations(){
        return avisService.getAvis();}

    @PutMapping("/avis/updateAvis")
    public Avis updateEvaluation(@RequestBody Avis evaluation){
        return  avisService.UpdateAvis(evaluation);

    }
    public  String deleteEvaluation(@PathVariable long id){
        avisService.deleteById(id);
        return "Deleted Successfully";
    }
}
