package com.br.odevjava.formulario.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.br.odevjava.formulario.entity.Usuario;

@Controller
public class FormularioController {
	
	// metodo http - get
	@GetMapping("/cadastrar")
	public String cadastrar(Model model) {
		model.addAttribute("usuario", new Usuario());
		return "cadastrar";
	}
	
	@PostMapping("/salvar")
	public String cadastrar(@ModelAttribute Usuario usuario) {
		IO.println(usuario.getNome());
		IO.println(usuario.getSexo());
		IO.println(usuario.getLogin());
		IO.println(usuario.getSenha());
		IO.println(usuario.getCargo());
		
		for (int i = 0; i < usuario.getHabilidades().size(); i++) {
			IO.println(usuario.getHabilidades().get(i));
		}
		
		return "index";
		
	}
	
	@GetMapping("/home")
	public String home(Model model) {
		model.addAttribute("tituloprincipal", "Seja bem-vindo a Página inicial");
		return "index";
	}
	
		
}
