/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.YoProgramo.backend.controller;

import com.YoProgramo.backend.model.Aprendizaje;
import com.YoProgramo.backend.service.AprendizajeService;
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
@RequestMapping("/aprendizaje")
@CrossOrigin(origins = {"https://frontendanto-57b59.web.app/"})
public class AprendizajeController {
    @Autowired
    AprendizajeService aprenServ;
    
    @GetMapping ("/list")
    public ResponseEntity<List<Aprendizaje>> list(){
        return new ResponseEntity(aprenServ.list(), HttpStatus.OK);
    }
    
    @GetMapping("/getOne/{id}")
    public ResponseEntity<Aprendizaje> detail(@PathVariable("id") int id){
        return new ResponseEntity(aprenServ.getOne(id), HttpStatus.OK);
    }
    
    @PostMapping("/save")
    public void save(@RequestBody Aprendizaje estu) { 
        aprenServ.save(estu);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable ("id") int id){
        aprenServ.delete(id);
    }
    
    @PutMapping("/update")
    public void edit(@RequestBody Aprendizaje estu) {
        aprenServ.save(estu);
    }
}
