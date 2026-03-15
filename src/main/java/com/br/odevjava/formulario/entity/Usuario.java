package com.br.odevjava.formulario.entity;

import java.util.ArrayList;
import java.util.List;

public class Usuario {
	public int id;
	String nome;
	String sexo;
	String login;
	String senha;
	String cargo;
	List<String> habilidades;
	
	public Usuario() {
	}

	public Usuario(String nome, String sexo, 
					String login, String senha, 
					String cargo, List<String> habilidades) {
		this.nome = nome;
		this.sexo = sexo;
		this.login = login;
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

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
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
	
	

}
