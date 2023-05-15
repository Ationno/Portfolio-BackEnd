/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.YoProgramo.backend.service;

import com.YoProgramo.backend.model.Experiencia;
import com.YoProgramo.backend.repository.ExperienciaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author anton
 */
@Service
public class ExperienciaService {
    @Autowired
    ExperienciaRepository expRepo;
    
    public List<Experiencia> list(){
        return expRepo.findAll();
    }
    
    public Experiencia getOne(long id){
        return expRepo.findById(id).orElse(null);
    }
    
    public void save(Experiencia apren){
        expRepo.save(apren);
    }  
    
    public void delete(long id) {
        expRepo.deleteById(id);
    }
}
