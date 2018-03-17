package com.rootfit.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rootfit.model.Aluno;

public interface AlunoRepository extends JpaRepository<Aluno, Long> {

}
