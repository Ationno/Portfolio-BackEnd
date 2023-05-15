/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.YoProgramo.backend.controller;

import com.YoProgramo.backend.model.Lenguaje;
import com.YoProgramo.backend.service.LenguajeService;
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
@RequestMapping("/lenguaje")
@CrossOrigin(origins = {"http://localhost:4200"})
public class LenguajeController {
    @Autowired
    LenguajeService lenServ;
    
    @GetMapping ("/list")
    public ResponseEntity<List<Lenguaje>> list(){
        return new ResponseEntity(lenServ.list(), HttpStatus.OK);
    }
    
    @GetMapping("/getOne/{id}")
    public ResponseEntity<Lenguaje> detail(@PathVariable("id") int id){
        return new ResponseEntity(lenServ.getOne(id), HttpStatus.OK);
    }
    
    @PostMapping("/save")
    public void save(@RequestBody Lenguaje estu) {      
        lenServ.save(estu);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable ("id") int id){
        lenServ.delete(id);
    }
    
    @PutMapping("/update")
    public void edit(@RequestBody Lenguaje estu) {      
        lenServ.save(estu);
    }
}