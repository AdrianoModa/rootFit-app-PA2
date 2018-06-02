package com.rootfit.controllers;

import java.net.URI;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.rootfit.model.Usuario;
import com.rootfit.repositories.UsuarioRepository;
import com.rootfit.services.UsuarioService;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private UsuarioService usuarioService;
    @Autowired BCryptPasswordEncoder encoder;

    @GetMapping
    public List<Usuario> listar(){
        return usuarioRepository.findAll();
    }
    
    @GetMapping("/{id}")
    public Usuario listarPorId(@PathVariable @Valid Long id){
		return usuarioRepository.findOne(id);    	
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Usuario> criar(@RequestBody @Valid Usuario usuario, HttpServletResponse response){
    	Usuario usuarioSalvo = usuarioService.adicionar(usuario);
    	URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}")
                .buildAndExpand(usuarioSalvo.getId()).toUri();
        response.setHeader("Location", uri.toASCIIString());
        return ResponseEntity.created(uri).body(usuarioSalvo);
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<Usuario> atualizar(@PathVariable Long id, @RequestBody Usuario usuario){
    	Usuario usuarioExistente = usuarioRepository.findOne(id);
    	if (usuarioExistente == null) {
			ResponseEntity.notFound().build();
		}
    	BeanUtils.copyProperties(usuario, usuarioExistente, "id");
    	String cryptoSenha = encoder.encode(usuario.getSenha());
    	usuarioExistente.setSenha(cryptoSenha);
    	usuario = usuarioRepository.save(usuarioExistente);    	
    	return ResponseEntity.ok(usuario);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> remover(@PathVariable Long id) {
    	Usuario usuarioExistente = usuarioRepository.findOne(id);
    	if (usuarioExistente == null) {
			ResponseEntity.notFound().build();
		}
    	usuarioRepository.delete(usuarioExistente.getId());
    	return ResponseEntity.noContent().build();
    }

}
