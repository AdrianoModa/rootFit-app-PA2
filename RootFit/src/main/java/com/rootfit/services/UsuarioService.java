package com.rootfit.services;

import java.util.Calendar;
import java.util.Optional;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.rootfit.model.Usuario;
import com.rootfit.repositories.UsuarioRepository;

@Service
public class UsuarioService {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	public Usuario adicionar(Usuario usuario) {
		usuario.setMatricula(gerarMatricula());
		String crptoPwd = cyptoPwd(usuario.getMatricula());
		usuario.setSenha(crptoPwd);
		return usuarioRepository.save(usuario);
	}
	
	public String gerarMatricula() {
		Random rdn = new Random();
		Calendar cldr = Calendar.getInstance();
		String year = Integer.toString(cldr.get(Calendar.YEAR));
		String ultsDoisDigts = year.substring(year.length() - 2);
		String month = Integer.toString(cldr.get(Calendar.MONTH));
		String quatrDigts = Integer.toString(rdn.nextInt(9999));
		String matricula = ultsDoisDigts + month + quatrDigts;
		if (compareMatricula(matricula));
			return matricula;
	}
	
	private Boolean compareMatricula(String matricula) {
		Optional<Usuario> usuario = usuarioRepository.findUsuarioByMatricula(matricula);
		while (usuario.isPresent()) {
			matricula = gerarMatricula();
			usuario = usuarioRepository.findUsuarioByMatricula(matricula);
		}
		return true;
	}
	
	public String cyptoPwd(String senha) {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		String crptoPwd = encoder.encode(senha);
		return crptoPwd;
	}


}
