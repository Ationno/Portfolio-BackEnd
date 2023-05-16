/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.YoProgramo.backend.controller;

import com.YoProgramo.backend.model.Habilidad;
import com.YoProgramo.backend.service.HabilidadService;
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
@RequestMapping("/habilidad")
@CrossOrigin(origins = {"https://frontendanto-7377e.web.app/"})
public class HabilidadController {
    @Autowired
    HabilidadService habServ;
    
    @GetMapping ("/list")
    public ResponseEntity<List<Habilidad>> list(){
        return new ResponseEntity(habServ.list(), HttpStatus.OK);
    }
    
    @GetMapping("/getOne/{id}")
    public ResponseEntity<Habilidad> detail(@PathVariable("id") int id){
        return new ResponseEntity(habServ.getOne(id), HttpStatus.OK);
    }
    
    @PostMapping("/save")
    public void save(@RequestBody Habilidad estu) {      
        habServ.save(estu);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable ("id") int id){
        habServ.delete(id);
    }
    
    @PutMapping("/update")
    public void edit(@RequestBody Habilidad estu) {      
        habServ.save(estu);
    }
}
