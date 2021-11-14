package com.example.parcialrenato.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.parcialrenato.entity.Cliente;
import com.example.parcialrenato.repository.ClienteRepository;
import com.example.parcialrenato.service.ClienteService;

@Service
public class ClienteServiceImpl implements ClienteService{

	@Autowired
	private ClienteRepository clienteRepository;
	@Override
	public List<Cliente> readAll() {
		// TODO Auto-generated method stub
		return clienteRepository.findAll();
	}

	@Override
	public Cliente read(int id) {
		// TODO Auto-generated method stub
		return clienteRepository.findById(id).get();
	}

	@Override
	public Cliente create(Cliente cliente) {
		// TODO Auto-generated method stub
		return clienteRepository.save(cliente);
	}

	@Override
	public Cliente update(Cliente cliente) {
		// TODO Auto-generated method stub
		return clienteRepository.save(cliente);
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		clienteRepository.deleteById(id);
	}

}
