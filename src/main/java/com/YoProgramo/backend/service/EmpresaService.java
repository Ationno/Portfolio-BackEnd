/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.YoProgramo.backend.service;

import com.YoProgramo.backend.model.Empresa;
import com.YoProgramo.backend.repository.EmpresaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author anton
 */
@Service
public class EmpresaService {
    @Autowired
    EmpresaRepository empRepo;
    
    public List<Empresa> list(){
        return empRepo.findAll();
    }
    
    public Empresa getOne(long id){
        return empRepo.findById(id).orElse(null);
    }
    
    public void save(Empresa apren){
        empRepo.save(apren);
    }  
    
    public void delete(long id) {
        empRepo.deleteById(id);
    }
}
