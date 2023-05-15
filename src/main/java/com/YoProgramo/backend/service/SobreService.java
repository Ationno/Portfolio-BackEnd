/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.YoProgramo.backend.service;

import com.YoProgramo.backend.model.Sobre;
import com.YoProgramo.backend.repository.SobreRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author anton
 */
@Service
public class SobreService {
    @Autowired
    SobreRepository sobreRepo;
    
    public List<Sobre> list(){
        return  sobreRepo.findAll();
    }
        
    public Sobre getOne(long id){
        return sobreRepo.findById(id).orElse(null);
    }
    
    public void save(Sobre apren){
        sobreRepo.save(apren);
    }  
    
    public void delete(long id) {
        sobreRepo.deleteById(id);
    }
}
