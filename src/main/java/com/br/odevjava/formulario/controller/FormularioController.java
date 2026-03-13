package com.br.odevjava.formulario.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class FormularioController {
	
	// metodo http - get
	@GetMapping("/cadastrar")
	public String cadastrar(Model model) {
		model.addAttribute("tituloh1", "Olá, seja bem-vindo ao formulário de cadastro.");
		model.addAttribute("nome", "Gabriel Eduardo Paulino Florentino");
		return "cadastrar";		
	}
	
	@PostMapping("/cadastrar")
	public void cadastrar() {
		
	}
	
	@GetMapping("/home")
	public String home(Model model) {
		model.addAttribute("tituloprincipal", "Seja bem-vindo a Página inicial");
		return "index";
	}
	
		
}
