package com.application.isge.AvisEvaluation.controller;

import com.application.isge.AvisEvaluation.model.Critere;
import com.application.isge.AvisEvaluation.service.CritereService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CritereController {
    @Autowired
    private CritereService critereService;
    @PostMapping("/createCritere")
    public Critere createCritere(@RequestBody Critere critere){
        return critereService.createCritere(critere);
    }
    public List<Critere> createCriteres(@RequestBody List<Critere> criteres){
        return  critereService.createCriteres(criteres);
    }

    @GetMapping("/critere/{id}")
    public Critere getCritereById(@PathVariable long id){

        return critereService.getCritereById(id);

    }

    @GetMapping("/criteres")
    public List <Critere> getCriteres(){
        return  critereService.getCriteres();

    }
    @PutMapping("/updateCritere")
    public Critere UpdateCritere(@RequestBody Critere critere){
        return  critereService.updateCritere(critere);
    }
    @DeleteMapping("/critere/{id}")
    public String deleteCritere(@PathVariable long id){
       return critereService.deleteById(id);
    }
}
