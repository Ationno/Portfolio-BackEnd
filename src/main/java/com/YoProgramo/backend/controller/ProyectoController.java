/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.YoProgramo.backend.controller;

import com.YoProgramo.backend.model.Imagen;
import com.YoProgramo.backend.model.Proyecto;
import com.YoProgramo.backend.service.ImagenService;
import com.YoProgramo.backend.service.LenguajeService;
import com.YoProgramo.backend.service.ProyectoService;
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
@RequestMapping("/proyecto")
@CrossOrigin(origins = {"http://localhost:4200"})
public class ProyectoController {
    @Autowired
    ProyectoService proyServ;
    
    @Autowired
    ImagenService imagenService;
    
    @Autowired
    LenguajeService lenguajeService;
    
    @GetMapping ("/list")
    public ResponseEntity<List<Proyecto>> list(){
        return new ResponseEntity(proyServ.list(), HttpStatus.OK);
    }
    
    @GetMapping("/getOne/{id}")
    public ResponseEntity<Proyecto> detail(@PathVariable("id") int id){
        return new ResponseEntity(proyServ.getOne(id), HttpStatus.OK);
    }
    
    @PostMapping("/save")
    public void save(@RequestBody Proyecto proy) {
        Imagen imgSobre = imagenService.findByNombre(proy.getImagen().getNombre()).orElse(null);
        if (imgSobre != null) {
            proy.setImagen(imgSobre);
        }
        proyServ.save(proy);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable ("id") int id){
        proyServ.delete(id);
    }
    
    @PutMapping("/update")
    public void edit(@RequestBody Proyecto proy) { 
        Imagen imgSobre = imagenService.findByNombre(proy.getImagen().getNombre()).orElse(null);
        if (imgSobre != null) {
            proy.setImagen(imgSobre);
        }
        proyServ.save(proy);
    }
}