package com.rootfit.DAO;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rootfit.model.Aluno;

public interface AlunoDAO extends JpaRepository<Aluno, Long> {

}
