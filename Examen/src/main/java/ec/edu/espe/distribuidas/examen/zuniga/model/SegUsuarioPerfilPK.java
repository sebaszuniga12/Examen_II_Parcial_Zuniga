/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.distribuidas.examen.zuniga.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author sebas
 */
@Data
@NoArgsConstructor
@Embeddable
public class SegUsuarioPerfilPK implements Serializable {

    @Column(name = "cod_usuario")
    private String codUsuario;
    @Column(name = "cod_perfil")
    private String codPerfil;


    public SegUsuarioPerfilPK(String codUsuario, String codPerfil) {
        this.codUsuario = codUsuario;
        this.codPerfil = codPerfil;
    }

    
    
}
