/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.YoProgramo.backend.controller;

import com.YoProgramo.backend.model.Educacion;
import com.YoProgramo.backend.model.Imagen;
import com.YoProgramo.backend.model.Institucion;
import com.YoProgramo.backend.service.EducacionService;
import com.YoProgramo.backend.service.ImagenService;
import com.YoProgramo.backend.service.InstitucionService;
import jakarta.transaction.Transactional;
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
@RequestMapping("/educacion")
@CrossOrigin(origins = {"https://frontendanto-7377e.web.app/"})
public class EducacionController {
    @Autowired
    EducacionService eduServ;
    
    @Autowired
    ImagenService imagenService;
    
    @Autowired
    InstitucionService institucionService;
    
    @GetMapping ("/list")
    public ResponseEntity<List<Educacion>> list(){
        return new ResponseEntity(eduServ.list(), HttpStatus.OK);
    }
    
    @GetMapping("/getOne/{id}")
    public ResponseEntity<Educacion> detail(@PathVariable("id") int id){
        return new ResponseEntity(eduServ.getOne(id), HttpStatus.OK);
    }
    
    @PostMapping("/save")
    public void save(@RequestBody Educacion edu) {     
        Imagen imgSobre = imagenService.findByNombre(edu.getImagen().getNombre()).orElse(null);
        if (imgSobre != null) {
            edu.setImagen(imgSobre);
        }
        Institucion instSobre = institucionService.findByNombre(edu.getInstitucion().getNombre()).orElse(null);
        if (instSobre != null) {
            edu.setInstitucion(instSobre);
        }
        eduServ.save(edu);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable ("id") int id){
        eduServ.delete(id);
    }
    
    @PutMapping("/update")
    @Transactional
    public void edit(@RequestBody Educacion edu) {
        Imagen imgSobre = imagenService.findByNombre(edu.getImagen().getNombre()).orElse(null);
        if (imgSobre != null) {
            edu.setImagen(imgSobre);
        }
        Institucion instSobre = institucionService.findByNombre(edu.getInstitucion().getNombre()).orElse(null);
        if (instSobre != null) {
            edu.setInstitucion(instSobre);
        }
        eduServ.save(edu);
    }
}
