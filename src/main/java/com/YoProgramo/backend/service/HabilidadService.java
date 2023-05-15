/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.YoProgramo.backend.service;

import com.YoProgramo.backend.model.Habilidad;
import com.YoProgramo.backend.repository.HabilidadRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author anton
 */
@Service
public class HabilidadService {
    @Autowired
    HabilidadRepository habRepo;
    
    public List<Habilidad> list(){
        return habRepo.findAll();
    }
    
    public Habilidad getOne(long id){
        return habRepo.findById(id).orElse(null);
    }
    
    public void save(Habilidad apren){
        habRepo.save(apren);
    }  
    
    public void delete(long id) {
        habRepo.deleteById(id);
    }
}
