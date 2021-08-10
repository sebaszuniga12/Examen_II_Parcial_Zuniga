/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.distribuidas.examen.zuniga.transform;

import ec.edu.espe.distribuidas.examen.zuniga.dto.SegUsuarioPerfilRS;
import ec.edu.espe.distribuidas.examen.zuniga.model.SegUsuarioPerfil;

/**
 *
 * @author sebas
 */
public class SegUsuarioPerfilRSTransform {
    
    
    
    public static SegUsuarioPerfilRS buildUsuarioPerfilRS(SegUsuarioPerfil usuarioPerfil){
        return SegUsuarioPerfilRS.builder()
                .codigoUsuario(usuarioPerfil.getSegUsuarioPerfilPK().getCodUsuario())
                .codigoPerfil(usuarioPerfil.getSegUsuarioPerfilPK().getCodPerfil())
                .estado(usuarioPerfil.getEstado())
               .porOmision(usuarioPerfil.getPorOmision())
                .build();

    }
}
