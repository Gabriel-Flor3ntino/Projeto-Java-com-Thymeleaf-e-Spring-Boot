package com.br.odevjava.formulario.controller;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.br.odevjava.formulario.entity.Usuario;
import com.br.odevjava.formulario.validation.CPFValidator;

@Controller
public class FormularioController {
	ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
	
	// metodo http - get
	@GetMapping("/cadastrar")
	public String cadastrar(Model model) {
		model.addAttribute("usuario", new Usuario());
		return "cadastrar";
	}
	
	@PostMapping("/salvar")
	public String cadastrar(@ModelAttribute Usuario usuario) {
		if (!CPFValidator.isValid(usuario.getCpf())) {
	        System.out.println("CPF inválido!");
	        return "cadastrar";
	    }
		IO.println(usuario.getNome());	IO.println(usuario.getCpf());
		IO.println(usuario.getSexo());	IO.println(usuario.getLogin());
		IO.println(usuario.getSenha());	IO.println(usuario.getCargo());
		IO.println(usuario.getHabilidades());
		
		boolean status = false;
		
		for (int i=0; i<usuarios.size(); i++) {
			Usuario usuario_aux = usuarios.get(i);
			
			if (usuario_aux.getCpf().equals(usuario.getCpf())) {
				usuario.setId(i);
				usuarios.set(i, usuario);
				i = usuarios.size();
				status = true;
			}
		}
		
		if (status == false) {
			usuario.setId(usuarios.size());			
			usuarios.add(usuario);
			return "index";
		} else {
			return "index";	
		}	
	}
	
	@GetMapping("/home")
	public String home(Model model) {
		model.addAttribute("tituloprincipal", "Seja bem-vindo a Página inicial");
		return "index";
	}
 
	@GetMapping("/editar{id}")
	public String editar(@PathVariable int id, Model model) {
		model.addAttribute("tituloh1", "Editar Cadastro");
		model.addAttribute("usuario", usuarios.get(id));
		return "cadastrar";
	}

	
	@GetMapping("/mostrar")
	public String mostrar(Model model) {
		model.addAttribute("usuarios", usuarios);
		return "mostrar";
	}
	
	@GetMapping("/excluir/{cpf}")
	public String excluir(@PathVariable String cpf, Model model) {
			
		for (int i=0; i<usuarios.size(); i++ ) {
			if (usuarios.get(i).getCpf().equals(cpf)) {
				model.addAttribute("tituloprincipal", usuarios.get(i).getNome()+" foi excluído com Sucesso!");
				usuarios.remove(usuarios.get(i));
				i = usuarios.size();
				return "redirect:/";
			}
		}
		
		model.addAttribute("tituloprincipal", "Página Inicial");
		return "redirect:/";
	}
		
}
