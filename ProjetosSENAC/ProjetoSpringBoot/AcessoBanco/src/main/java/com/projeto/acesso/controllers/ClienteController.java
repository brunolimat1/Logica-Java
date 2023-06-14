package com.projeto.acesso.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projeto.acesso.Repository.ClienteRepository;
import com.projeto.acesso.models.Cliente;

@RestController
public class ClienteController {

	@Autowired
	private ClienteRepository clienteRepo;

	@GetMapping("/clientes/listar")
	public List<Cliente> listar() {
		return clienteRepo.findAll();
	}

}
