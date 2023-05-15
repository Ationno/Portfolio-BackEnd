/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.YoProgramo.backend.service;

import com.YoProgramo.backend.model.Educacion;
import com.YoProgramo.backend.repository.EducacionRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author anton
 */
@Service
public class EducacionService {
    @Autowired
    EducacionRepository eduRepo;
    
    public List<Educacion> list(){
        return eduRepo.findAll();
    }
    
    public Educacion getOne(long id){
        return eduRepo.findById(id).orElse(null);
    }
    
    public void save(Educacion apren){
        eduRepo.save(apren);
    }  
    
    public void delete(long id) {
        eduRepo.deleteById(id);
    }
}
