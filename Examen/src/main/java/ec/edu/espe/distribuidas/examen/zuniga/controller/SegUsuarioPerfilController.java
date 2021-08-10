/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.distribuidas.examen.zuniga.controller;

import ec.edu.espe.distribuidas.examen.zuniga.dto.PerfilRQ;
import ec.edu.espe.distribuidas.examen.zuniga.dto.PerfilUsuarioRQ;
import ec.edu.espe.distribuidas.examen.zuniga.dto.SegUsuarioPerfilRS;
import ec.edu.espe.distribuidas.examen.zuniga.model.SegUsuarioPerfil;
import ec.edu.espe.distribuidas.examen.zuniga.model.SegUsuarioPerfilPK;
import ec.edu.espe.distribuidas.examen.zuniga.response.BadRequestRS;
import ec.edu.espe.distribuidas.examen.zuniga.services.SegUsuarioPerfilService;
import ec.edu.espe.distribuidas.examen.zuniga.transform.SegUsuarioPerfilRSTransform;
import io.github.classgraph.utils.Parser.ParseException;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import java.util.ArrayList;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author sebas
 */
@RestController
@Slf4j
@RequestMapping("/v1/perfil")
public class SegUsuarioPerfilController {
    
     private final SegUsuarioPerfilService service;

    public SegUsuarioPerfilController(SegUsuarioPerfilService service) {
        this.service = service;
    }
    
    @GetMapping(value = "estado/{estado}")
    @ApiOperation(value = "Obtener todos los perfiles de usuario activos",
            notes = "Obtiene los perfiles activos de la base de datos",
            response = SegUsuarioPerfil.class, hidden = false)
    @ApiResponses(value = {
            @ApiResponse(code = 200,
                    message = "Retorna una lista de los perfiles de usuario activos vacía si no existe ninguno en la base",
                    response = SegUsuarioPerfil.class,
                    responseContainer = "List")
    })
    public ResponseEntity obtenerPerfilesActivos(@PathVariable("estado") String estado) {
        List<SegUsuarioPerfil> pefiles = this.service.listAll(estado); 
        List<SegUsuarioPerfilRS> response = new ArrayList<>();
        pefiles.forEach(perfil -> response.add(SegUsuarioPerfilRSTransform.buildUsuarioPerfilRS(perfil)));
        return ResponseEntity.ok(response);
    }
    
    
    @PostMapping
       @ApiOperation(value = "Crear una perfiles de usuarios",
            notes = "Crea varios perfiles de un usuario de acuerdo a los datos enviados",
            response = SegUsuarioPerfil.class)
    @ApiResponses(value = {
            @ApiResponse(code = 201,
                    message = "Cuando se crea varios perfiles de usuario de acuerdo a los datos enviados",
                    response = SegUsuarioPerfil.class),
            @ApiResponse(code = 400,
                    message = "Cuando no se puede crear los perfiles de usuario los datos enviados",
                    response = BadRequestRS.class)
    })
    public ResponseEntity generarUsuariosPerfil(@RequestBody PerfilUsuarioRQ request){
        List<SegUsuarioPerfil> perfiles = new ArrayList<>();
        for(PerfilRQ perfilRQ: request.getPerfiles()){
            SegUsuarioPerfil perfil = new SegUsuarioPerfil();
            SegUsuarioPerfilPK pk = new SegUsuarioPerfilPK();
            pk.setCodUsuario(request.getCodigoUsuario());
            pk.setCodPerfil(perfilRQ.getCodigoPerfil());
            perfil.setSegUsuarioPerfilPK(pk);
            perfiles.add(perfil);
        }
       this.service.createUsuariosPerfil(perfiles);
        return ResponseEntity.ok().build();
    }
}
