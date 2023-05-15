/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.YoProgramo.backend.service;

import com.YoProgramo.backend.model.Imagen;
import com.YoProgramo.backend.model.Lenguaje;
import com.YoProgramo.backend.repository.LenguajeRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author anton
 */
@Service
public class LenguajeService {
    @Autowired
    LenguajeRepository lenRepo;
    
    public Optional<Lenguaje> findByNombre(String nombre) {
        return lenRepo.findByNombre(nombre);
    }
    
    public List<Lenguaje> list(){
        return lenRepo.findAll();
    }
    
    public Lenguaje getOne(long id){
        return lenRepo.findById(id).orElse(null);
    }
    
    public void save(Lenguaje apren){
        lenRepo.save(apren);
    }  
    
    public void delete(long id) {
        lenRepo.deleteById(id);
    }
}
