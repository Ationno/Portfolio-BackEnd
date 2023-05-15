/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.YoProgramo.backend.model;

/**
 *
 * @author anton
 */
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotNull;
import java.util.Set;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class Imagen {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @NotNull
    private String tipo;
    
    @NotNull
    private String nombre;

    @Column(length = 1000000)
    private byte[] base64;

    @JsonIgnore
    @OneToMany(mappedBy="imagen", cascade=CascadeType.ALL)
    private Set<Proyecto> proyectos;
    
    @JsonIgnore
    @OneToMany(mappedBy="imagen", cascade = CascadeType.ALL)
    private Set<Educacion> educaciones;
    
    public Imagen() {}

    public Imagen(String tipo, String nombre, byte[] byte64) {
        this.tipo = tipo;
        this.nombre = nombre;
        this.base64 = byte64;
    }
}
