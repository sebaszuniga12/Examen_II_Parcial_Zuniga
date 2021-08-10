/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.distribuidas.examen.zuniga.services;

import ec.edu.espe.distribuidas.examen.zuniga.dao.SegPerfilRepository;
import ec.edu.espe.distribuidas.examen.zuniga.dao.SegUsuarioPerfilRepository;
import ec.edu.espe.distribuidas.examen.zuniga.dao.SegUsuarioRepository;
import ec.edu.espe.distribuidas.examen.zuniga.exception.CreateException;
import ec.edu.espe.distribuidas.examen.zuniga.model.SegPerfil;
import ec.edu.espe.distribuidas.examen.zuniga.model.SegUsuario;
import ec.edu.espe.distribuidas.examen.zuniga.model.SegUsuarioPerfil;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 *
 * @author sebas
 */
@Service
@Slf4j
public class SegUsuarioPerfilService {
    
     private final SegUsuarioPerfilRepository segUsuarioPerfilRepository;
     private final SegUsuarioRepository segUsuarioRepository;
     private final SegPerfilRepository segPerfilRepository;

    public SegUsuarioPerfilService(SegUsuarioPerfilRepository segUsuarioPerfilRepository, SegUsuarioRepository segUsuarioRepository, SegPerfilRepository segPerfilRepository) {
        this.segUsuarioPerfilRepository = segUsuarioPerfilRepository;
        this.segUsuarioRepository = segUsuarioRepository;
        this.segPerfilRepository = segPerfilRepository;
    }

      /*-----------------------------------------Busqueda-----------------------------------------*/

    public List<SegUsuarioPerfil> listAll(String estado) {
        return this.segUsuarioPerfilRepository.findByEstado(estado); 
    }
    
    
    
    /*-----------------------------------------Creación-----------------------------------------*/
    @Transactional
    public List<SegUsuarioPerfil> createUsuariosPerfil(List<SegUsuarioPerfil> usuario) {
        Integer cont = 0;
        for (SegUsuarioPerfil usuarioPerfil : usuario) {
        Optional<SegUsuario> segUsuarioOptional = this.segUsuarioRepository.findById(usuarioPerfil.getSegUsuarioPerfilPK().getCodUsuario());
        if (segUsuarioOptional.isEmpty()) {
            StringBuilder sbMsg = new StringBuilder("The Usuario with code: ");
            sbMsg.append(usuarioPerfil.getSegUsuarioPerfilPK().getCodUsuario());
            sbMsg.append(" is not in the database");
            throw new CreateException(sbMsg.toString());
        } else {
            usuarioPerfil.setSegUsuario(segUsuarioOptional.get());
        }
        Optional<SegPerfil> segPerfilOptional = this.segPerfilRepository.findById(usuarioPerfil.getSegUsuarioPerfilPK().getCodPerfil());
        if (segPerfilOptional.isEmpty()) {
            StringBuilder sbMsg = new StringBuilder("The PERFIL with code: ");
            sbMsg.append(usuarioPerfil.getSegUsuarioPerfilPK().getCodPerfil());
            sbMsg.append(" is not in the database");
            throw new CreateException(sbMsg.toString());
        } else {
            usuarioPerfil.setSegPerfil(segPerfilOptional.get());
        }
        usuarioPerfil.setEstado("ACT");
        if(cont == 0){
            usuarioPerfil.setPorOmision("S");
            cont++;
        }
        else{
            usuarioPerfil.setPorOmision("N");
        }
    }
         return this.segUsuarioPerfilRepository.saveAll(usuario);
    }


       
    
}
