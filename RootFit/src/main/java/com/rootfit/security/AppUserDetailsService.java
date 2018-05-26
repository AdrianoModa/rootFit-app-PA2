package com.rootfit.security;

import com.rootfit.model.TipoUsuario;
import com.rootfit.model.Usuario;
import com.rootfit.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class AppUserDetailsService implements UserDetailsService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public UserDetails loadUserByUsername(String matricula) throws UsernameNotFoundException {
        Optional<Usuario> usuarioOptional = usuarioRepository.findUsuarioByMatricula(matricula);
        Usuario usuario = usuarioOptional.orElseThrow(() -> new UsernameNotFoundException("usuario e/ou senha incorretos!"));
        return new UsuarioSistema(usuario, getPermissoes(usuario.getTipoUsuario()));
    }

    private Collection<? extends GrantedAuthority> getPermissoes(TipoUsuario tipoUsuario) {
        Set<SimpleGrantedAuthority> authorities = new HashSet<>();
        tipoUsuario.getPermissoes().forEach(p -> authorities.add(new SimpleGrantedAuthority(p.getDescricao().toUpperCase())));
        return authorities;
    }
}
