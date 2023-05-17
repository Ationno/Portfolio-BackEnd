/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.YoProgramo.backend.controller;

import com.YoProgramo.backend.model.Empresa;
import com.YoProgramo.backend.model.Experiencia;
import com.YoProgramo.backend.model.Imagen;
import com.YoProgramo.backend.service.EmpresaService;
import com.YoProgramo.backend.service.ExperienciaService;
import com.YoProgramo.backend.service.ImagenService;
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
@RequestMapping("/experiencia")
@CrossOrigin(origins = {"https://frontendanto-57b59.web.app/"})
public class ExperienciaController {
    @Autowired
    ExperienciaService expServ;
    
    @Autowired
    ImagenService imagenService;
    
    @Autowired
    EmpresaService empresaService;
    
    @GetMapping ("/list")
    public ResponseEntity<List<Experiencia>> list(){
        return new ResponseEntity(expServ.list(), HttpStatus.OK);
    }
    
    @GetMapping("/getOne/{id}")
    public ResponseEntity<Experiencia> detail(@PathVariable("id") int id){
        return new ResponseEntity(expServ.getOne(id), HttpStatus.OK);
    }
    
    @PostMapping("/save")
    public void save(@RequestBody Experiencia estu) {  
        Imagen imgSobre = imagenService.findByNombre(estu.getImagen().getNombre()).orElse(null);
        if (imgSobre != null) {
            estu.setImagen(imgSobre);
        }
        Empresa empSobre = empresaService.findByNombre(estu.getEmpresa().getNombre()).orElse(null);
        if (empSobre != null) {
            estu.setEmpresa(empSobre);
        }
        expServ.save(estu);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable ("id") int id){
        expServ.delete(id);
    }
    
    @PutMapping("/update")
    public void edit(@RequestBody Experiencia estu) {      
        Imagen imgSobre = imagenService.findByNombre(estu.getImagen().getNombre()).orElse(null);
        if (imgSobre != null) {
            estu.setImagen(imgSobre);
        }
        Empresa empSobre = empresaService.findByNombre(estu.getEmpresa().getNombre()).orElse(null);
        if (empSobre != null) {
            estu.setEmpresa(empSobre);
        }
        estu.getAprendizajes().forEach(elem -> System.out.println(elem.getParrafo()));
        expServ.save(estu);
    }
}