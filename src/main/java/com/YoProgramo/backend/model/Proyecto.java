/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.YoProgramo.backend.model;

/**
 *
 * @author anton
 */
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size; 
import java.util.Set;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class Proyecto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @NotNull
    @Size(min = 1, max = 90, message = "La longitud del titulo del proyecto no es valido")
    private String titulo;
    
    @NotNull
    @Column(length = 2000)
    private String parrafo;
    
    @NotNull
    @Size(min = 1, max = 90, message = "La longitud del link de GitHub del proyecto no es valido")
    private String linkGit;
    
    @Size(min = 1, max = 90, message = "La longitud del link de GitHub del proyecto no es valido")
    private String linkPag;
    
    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "imagen_id")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Imagen imagen;
    
    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    Set<Lenguaje> lenguajes;   

    public Proyecto() {}
    
    public Proyecto(String titulo, String parrafo, String linkGit, String linkPag, Imagen imagen, Set<Lenguaje> lenguajesUsados) {
        this.titulo = titulo;
        this.parrafo = parrafo;
        this.linkGit = linkGit;
        this.linkPag = linkPag;
        this.imagen = imagen;
        this.lenguajes = lenguajesUsados;
    }
    
    
}
