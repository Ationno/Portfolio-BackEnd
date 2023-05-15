/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.YoProgramo.backend.service;

import com.YoProgramo.backend.model.Aprendizaje;
import com.YoProgramo.backend.repository.AprendizajeRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author anton
 */

@Service
public class AprendizajeService {
    @Autowired
    AprendizajeRepository aprenRepo;
    
    public List<Aprendizaje> list(){
        return aprenRepo.findAll();
    }
    
    public Aprendizaje getOne(long id){
        return aprenRepo.findById(id).orElse(null);
    }
    
    public void save(Aprendizaje apren){
        aprenRepo.save(apren);
    }  
    
    public void delete(long id) {
        aprenRepo.deleteById(id);
    }
}
