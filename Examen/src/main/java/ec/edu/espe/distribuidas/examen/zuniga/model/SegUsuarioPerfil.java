/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.distribuidas.examen.zuniga.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import lombok.Data;

/**
 *
 * @author sebas
 */
@Data
@Entity
@Table(name = "seg_usuario_perfil")
public class SegUsuarioPerfil implements Serializable {

    @EmbeddedId
    protected SegUsuarioPerfilPK segUsuarioPerfilPK;
    @Column(name = "estado")
    private String estado;
    @Column(name = "por_omision")
    private String porOmision;
    @JoinColumn(name = "cod_perfil", referencedColumnName = "cod_perfil", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private SegPerfil segPerfil;
    @JoinColumn(name = "cod_usuario", referencedColumnName = "cod_usuario", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private SegUsuario segUsuario;
   
}
