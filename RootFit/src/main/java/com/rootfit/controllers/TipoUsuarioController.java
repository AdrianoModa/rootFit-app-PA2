package com.rootfit.controllers;


import com.rootfit.model.TipoUsuario;
import com.rootfit.repositories.TipoUsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/tipo-usuario")
//@CrossOrigin("${origem-permitida}")
public class TipoUsuarioController {

    @Autowired
    private TipoUsuarioRepository tipoUsuarioRepository;

    @GetMapping
    //@PreAuthorize("hasAuthority('ROLE_PESQUISAR_COLABORADOR') and #oauth2.hasScope('read')")
    public List<TipoUsuario> listar() {
        return tipoUsuarioRepository.findAll();
    }

}
