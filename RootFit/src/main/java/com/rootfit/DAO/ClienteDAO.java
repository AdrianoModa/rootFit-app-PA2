package com.rootfit.DAO;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rootfit.model.Cliente;

public interface ClienteDAO extends JpaRepository<Cliente, Long> {

}
