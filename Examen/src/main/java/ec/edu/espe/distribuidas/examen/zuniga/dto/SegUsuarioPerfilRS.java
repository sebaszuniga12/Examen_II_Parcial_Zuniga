/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.distribuidas.examen.zuniga.dto;

import java.util.Date;
import lombok.Builder;
import lombok.Data;

/**
 *
 * @author sebas
 */
@Data
@Builder
public class SegUsuarioPerfilRS {
    
    private String codigoUsuario;
    private String codigoPerfil;
    private String estado;
    private String porOmision;
   
}
