package com.br.odevjava.formulario.controller;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.br.odevjava.formulario.entity.Usuario;
import com.br.odevjava.formulario.validation.CPFValidator;

@Controller
public class FormularioController {

    ArrayList<Usuario> usuarios = new ArrayList<>();

    @GetMapping("/cadastrar")
    public String cadastrar(Model model) {
        model.addAttribute("usuario", new Usuario());
        return "cadastrar";
    }

    @PostMapping("/salvar")
    public String cadastrar(@ModelAttribute Usuario usuario, Model model) {

        // valida CPF
        if (!CPFValidator.isValid(usuario.getCpf())) {
            model.addAttribute("erroCpf", "CPF inválido! Verifique o número digitado.");
            model.addAttribute("usuario", new Usuario()); // limpa o formulário
            return "cadastrar";
        }

        System.out.println(usuario.getNome());
        System.out.println(usuario.getCpf());
        System.out.println(usuario.getSexo());
        System.out.println(usuario.getLogin());
        System.out.println(usuario.getSenha());
        System.out.println(usuario.getCargo());
        System.out.println(usuario.getHabilidades());

        boolean status = false;

        for (int i = 0; i < usuarios.size(); i++) {
            Usuario usuario_aux = usuarios.get(i);

            if (usuario_aux.getCpf().equals(usuario.getCpf())) {
                usuario.setId(i);
                usuarios.set(i, usuario);
                status = true;
                break;
            }
        }

        if (!status) {
            usuario.setId(usuarios.size());
            usuarios.add(usuario);
        }

        return "redirect:/home";
    }

    @GetMapping("/home")
    public String home(Model model) {
        model.addAttribute("tituloprincipal", "Seja bem-vindo a Página inicial");
        return "index";
    }

    @GetMapping("/editar/{id}")
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

        for (int i = 0; i < usuarios.size(); i++) {

            if (usuarios.get(i).getCpf().equals(cpf)) {
                model.addAttribute("tituloprincipal",
                        usuarios.get(i).getNome() + " foi excluído com sucesso!");
                usuarios.remove(i);
                break;
            }
        }

        return "redirect:/home";
    }
}