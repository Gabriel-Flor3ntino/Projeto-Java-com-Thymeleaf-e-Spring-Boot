package com.br.odevjava.formulario.entity;

import java.util.List;

public class Usuario {
	public int id;
	public String nome;
	public String cpf;
	public String sexo;
	private String email;
	public String senha;
	public String cargo;
	List<String> habilidades;
	
	public Usuario() {
	}

	public Usuario(String nome, String cpf, 
				   String sexo, String email, 
				   String senha, String cargo, 
				   List<String> habilidades) {
		this.nome = nome;
		this.cpf = cpf;
		this.sexo = sexo;
		this.email = email;
		this.senha = senha;
		this.cargo = cargo;
		this.habilidades = habilidades;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getEmail() {
	    return email;
	}

	public void setEmail(String email) {
	    this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public List<String> getHabilidades() {
		return habilidades;
	}

	public void setHabilidades(List<String> habilidades) {
		this.habilidades = habilidades;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	

}
