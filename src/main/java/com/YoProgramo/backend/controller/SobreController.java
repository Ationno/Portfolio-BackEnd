/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.YoProgramo.backend.controller;

import com.YoProgramo.backend.model.Imagen;
import com.YoProgramo.backend.model.Sobre;
import com.YoProgramo.backend.service.ImagenService;
import com.YoProgramo.backend.service.SobreService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author anton
 */
@RestController
@RequestMapping("/sobre")
@CrossOrigin(origins = {"http://localhost:4200"})
public class SobreController {
    @Autowired
    SobreService sobreServ;
    
    @Autowired
    ImagenService imagenService;
    
    @GetMapping ("/list")
    public ResponseEntity<List<Sobre>> list(){
        return new ResponseEntity(sobreServ.list(), HttpStatus.OK);
    }
    
    @GetMapping("/getOne/{id}")
    public ResponseEntity<Sobre> detail(@PathVariable("id") int id){
        return new ResponseEntity(sobreServ.getOne(id), HttpStatus.OK);
    }
    
    @PostMapping("/save")
    public void save(@RequestBody Sobre sobre) {  
        Imagen imgSobre = imagenService.findByNombre(sobre.getImagen().getNombre()).orElse(null);
        if (imgSobre != null) {
            sobre.setImagen(imgSobre);
        }
        sobreServ.save(sobre);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable ("id") int id){
        sobreServ.delete(id);
    }
    
    @PutMapping("/update")
    public void edit(@RequestBody Sobre sobre) {    
        Imagen imgSobre = imagenService.findByNombre(sobre.getImagen().getNombre()).orElse(null);
        if (imgSobre != null) {
            sobre.setImagen(imgSobre);
        }
        sobreServ.save(sobre);
    }
}