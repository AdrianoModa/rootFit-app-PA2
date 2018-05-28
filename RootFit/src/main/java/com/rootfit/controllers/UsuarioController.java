package com.rootfit.controllers;

import com.rootfit.model.Usuario;
import com.rootfit.repositories.UsuarioRepository;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import javax.validation.Valid;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioRepository usuarioRepository;
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
    public Usuario criar(@RequestBody Usuario usuario){
        return usuarioRepository.save(usuario);
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
