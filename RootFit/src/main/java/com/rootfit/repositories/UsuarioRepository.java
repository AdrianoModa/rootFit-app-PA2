package com.rootfit.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rootfit.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    public Optional<Usuario> findUsuarioByMatricula(String matricula);

}
