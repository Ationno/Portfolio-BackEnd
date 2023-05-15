/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.YoProgramo.backend.service;

import com.YoProgramo.backend.model.Imagen;
import com.YoProgramo.backend.repository.ImagenRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author anton
 */
@Service
public class ImagenService {
    @Autowired
    ImagenRepository imgRepo;
     
    public Optional<Imagen> findByNombre(String nombre) {
        return imgRepo.findByNombre(nombre);
    }
    
    public List<Imagen> list(){
        return imgRepo.findAll();
    }
    
    public Imagen getOne(long id){
        return imgRepo.findById(id).orElse(null);
    }
    
    public void save(Imagen apren){
        imgRepo.save(apren);
    }  
    
    public void delete(long id) {
        imgRepo.deleteById(id);
    }
}
