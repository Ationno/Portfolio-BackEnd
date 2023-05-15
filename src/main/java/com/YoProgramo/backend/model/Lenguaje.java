/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.YoProgramo.backend.model;

/**
 *
 * @author anton
 */

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.util.Set;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class Lenguaje {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @NotNull 
    @Size(min = 1, max = 90, message = "La longitud del nombre del lenguaje no es valido")
    private String nombre;
    
    @ManyToMany(mappedBy = "lenguajesUsados")
    Set<Proyecto> proyectos;

    public Lenguaje(String nombre, Set<Proyecto> proyectos) {
        this.nombre = nombre;
        this.proyectos = proyectos;
    }
}
