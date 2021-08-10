/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.distribuidas.examen.zuniga.dao;

import ec.edu.espe.distribuidas.examen.zuniga.model.SegPerfil;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author sebas
 */
public interface SegPerfilRepository extends JpaRepository<SegPerfil,String>{
    
}
