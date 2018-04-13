package com.rootfit.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rootfit.model.Exercicio;

public interface ExercicioRepository extends JpaRepository<Exercicio, Long> {
	

}
