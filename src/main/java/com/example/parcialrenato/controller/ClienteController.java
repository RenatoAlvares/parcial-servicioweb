package com.example.parcialrenato.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.parcialrenato.entity.Cliente;
import com.example.parcialrenato.service.ClienteService;

@RestController
@RequestMapping("/api/cliente")
public class ClienteController {

	@Autowired
	private ClienteService clienteService;

	@GetMapping("/all")
	public ResponseEntity<List<Cliente>> getCliente(){
		try {
			List<Cliente> lista = new ArrayList<>();
			lista = clienteService.readAll();
			if(lista.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}else {
				return new ResponseEntity<>(lista, HttpStatus.OK);
			}
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Cliente> getCliente(@PathVariable("id") int id){
		Cliente c = clienteService.read(id);
		if(c.getId()>0) {
			return new ResponseEntity<>(c, HttpStatus.OK);
		}else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<HttpStatus> delete(@PathVariable("id") int id){
		try {
			clienteService.delete(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PostMapping("/create")
	public ResponseEntity<Cliente> save(@RequestBody Cliente cli){
		try {
			Cliente c = new Cliente();
			c.setNombres(cli.getNombres());
			c.setApellidoPaterno(cli.getApellidoPaterno());
			c.setApellidoMaterno(cli.getApellidoMaterno());
			c.setDni(cli.getDni());
			c.setDireccion(cli.getDireccion());
			c.setEmail(cli.getEmail());
			c.setFechaRegistro(cli.getFechaRegistro());
			Cliente cl = clienteService.create(c);
			return new ResponseEntity<>(cl, HttpStatus.CREATED);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<Cliente> update(@RequestBody Cliente cli, @PathVariable("id") int id){
		try {
			Cliente c = clienteService.read(id);
			if(c.getId()>0) {
				c.setNombres(cli.getNombres());
				c.setApellidoPaterno(cli.getApellidoPaterno());
				c.setApellidoMaterno(cli.getApellidoMaterno());
				c.setDni(cli.getDni());
				c.setDireccion(cli.getDireccion());
				c.setEmail(cli.getEmail());
				c.setFechaRegistro(cli.getFechaRegistro());
				return new ResponseEntity<>(clienteService.create(c),HttpStatus.OK);
			}else {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}			

		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
}
