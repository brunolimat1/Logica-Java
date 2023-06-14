package com.projeto.acesso.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projeto.acesso.models.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente,Integer>{

}
