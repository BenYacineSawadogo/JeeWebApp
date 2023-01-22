package com.application.isge.AvisEvaluation.service;

import com.application.isge.AvisEvaluation.dto.CritereRepository;
import com.application.isge.AvisEvaluation.model.Critere;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CritereService {
    @Autowired
     private CritereRepository critereRepository;

   public Critere createCritere(Critere critere){

        return critereRepository.save(critere);
   }
     public List <Critere> createCriteres(List <Critere> critere){

          return critereRepository.saveAll(critere);
     }

     public Critere getCritereById(long id){
        return critereRepository.findById(id).orElse(null);
     }

    public List<Critere> getCriteres(){
        return critereRepository.findAll();
    }

    public Critere updateCritere(Critere critere) {
        Optional<Critere> optionalCritere = critereRepository.findById(critere.getCritere_id());
        Critere oldCritere;
        if (optionalCritere.isPresent()) {
            oldCritere = optionalCritere.get();
            oldCritere.setNom(critere.getNom());
            critereRepository.save(oldCritere);
        } else {
            return new Critere();
        }
        return oldCritere;

    }

    public String deleteById(long id){
       critereRepository.deleteById(id);
       return  "Critere Deleted successfully";
    }














}
