package com.example.parcialrenato.service;

import java.util.List;

import com.example.parcialrenato.entity.Cliente;

public interface ClienteService {

	List<Cliente> readAll();
	Cliente read(int id);
	Cliente create(Cliente cliente);
	Cliente update(Cliente cliente);
	void delete(int id);
}
