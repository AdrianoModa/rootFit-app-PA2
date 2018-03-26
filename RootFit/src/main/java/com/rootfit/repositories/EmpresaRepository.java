package com.rootfit.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rootfit.model.Empresa;

public interface EmpresaRepository extends JpaRepository<Empresa, Long> {

}
