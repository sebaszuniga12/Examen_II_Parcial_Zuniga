/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.distribuidas.examen.zuniga.model;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import lombok.Data;

/**
 *
 * @author sebas
 */
@Data
@Entity
@Table(name = "seg_perfil")
public class SegPerfil implements Serializable {

    @Id
    @Column(name = "cod_perfil")
    private String codPerfil;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "estado")
    private String estado;

   
}
