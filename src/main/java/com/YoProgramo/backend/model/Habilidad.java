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
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class Habilidad {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @NotNull
    @Size(min = 1, max = 90, message = "La longitud del titulo del proyecto no es valido")
    private String titulo;
    
    @NotNull
    private String parrafo;
    
    @NotNull
    private int porcentaje;
    
    @NotNull
    private int tipo;
    
    public Habilidad() {}
    
    public Habilidad(String titulo, String parrafo, int porcentaje, int tipo) {
        this.titulo = titulo;
        this.parrafo = parrafo;
        this.porcentaje = porcentaje;
        this.tipo = tipo;
    }
}
