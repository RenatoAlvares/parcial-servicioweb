package com.example.parcialrenato.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

	@GetMapping("/")
	String mensaje() {
		return "<h1>Evaluación Parcial 2021</h1></hr><h2>Renato Alvares Pérez</h2>";
	}
}
