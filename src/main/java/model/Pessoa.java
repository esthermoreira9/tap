package model;

import java.util.ArrayList;
import java.util.List;

public class Pessoa {
	
	private String nome;
	private int idade;
	private String endeco;
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getIdade() {
		return idade;
	}
	public void setIdade(int idade) {
		this.idade = idade;
	}
	public String getEndeco() {
		return endeco;
	}
	public void setEndeco(String endeco) {
		this.endeco = endeco;
	}
	public Pessoa(String nome, int idade, String endeco) {
		super();
		this.nome = nome;
		this.idade = idade;
		this.endeco = endeco;
	}

}
