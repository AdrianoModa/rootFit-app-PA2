package com.rootfit.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rootfit.model.Aluno;

public interface AlunoRepository extends JpaRepository<Aluno, Long> {
	
	public Optional<Aluno> findAlunoByMatricula(String matricula);

}
