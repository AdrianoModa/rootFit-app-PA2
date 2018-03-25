package com.rootfit.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rootfit.model.Cidade;

public interface CidadeRepository extends JpaRepository<Cidade, Long> {

}
