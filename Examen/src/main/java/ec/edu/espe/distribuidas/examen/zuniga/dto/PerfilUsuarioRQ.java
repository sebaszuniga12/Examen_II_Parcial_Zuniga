/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.distribuidas.examen.zuniga.dto;

import java.util.List;
import lombok.Data;

/**
 *
 * @author sebas
 */
@Data
public class PerfilUsuarioRQ {
    String codigoUsuario;
    List<PerfilRQ> perfiles;
}
