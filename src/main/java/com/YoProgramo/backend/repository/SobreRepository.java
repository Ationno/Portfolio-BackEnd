/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.YoProgramo.backend.repository;

import com.YoProgramo.backend.model.Sobre;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author anton
 */
@Repository
public interface SobreRepository extends JpaRepository<Sobre, Long>{
}
