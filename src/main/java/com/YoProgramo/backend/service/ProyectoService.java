/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.YoProgramo.backend.service;

import com.YoProgramo.backend.model.Proyecto;
import com.YoProgramo.backend.repository.ProyectoRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author anton
 */
@Service
public class ProyectoService {
    @Autowired
    ProyectoRepository proyRepo;
    
    public List<Proyecto> list(){
        return proyRepo.findAll();
    }
    
    public Proyecto getOne(long id){
        return proyRepo.findById(id).orElse(null);
    }
    
    public void save(Proyecto apren){
        proyRepo.save(apren);
    }  
    
    public void delete(long id) {
        proyRepo.deleteById(id);
    }
}
