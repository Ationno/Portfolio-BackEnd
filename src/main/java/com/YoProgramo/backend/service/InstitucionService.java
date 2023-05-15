/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.YoProgramo.backend.service;

import com.YoProgramo.backend.model.Institucion;
import com.YoProgramo.backend.repository.InstitucionRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author anton
 */
@Service
public class InstitucionService {
    @Autowired
    InstitucionRepository instRepo;
    
    public Optional<Institucion> findByNombre(String nombre) {
        return instRepo.findByNombre(nombre);
    }
    
    public List<Institucion> list(){
        return instRepo.findAll();
    }
    
    public Institucion getOne(long id){
        return instRepo.findById(id).orElse(null);
    }
    
    public void save(Institucion apren){
        instRepo.save(apren);
    }  
    
    public void delete(long id) {
        instRepo.deleteById(id);
    }
}
