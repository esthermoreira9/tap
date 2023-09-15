package com.unifacisa.tap.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.unifacisa.tap.entity.Pessoa;
import com.unifacisa.tap.repository.PessoaRepository;

@Service
public class PessoaService {
	
	@Autowired
	PessoaRepository pessoaRepository;
	
	public List<Pessoa> listarTodasPessoas() {
		return pessoaRepository.findAll();
	}
	
	public Pessoa cadastrarPessoa(Pessoa pessoa) {
		return pessoaRepository.save(pessoa);
	}
	
	public Pessoa listarUsuarioPorId(int id) {
		return this.pessoaRepository.findById(id).get();
	}
	
	public void deletarPessoa(int id) {
		this.pessoaRepository.deleteById(id);
	}
	
	public Pessoa editarPessoa(Pessoa pessoa, int id) {
		pessoa.setId(id);
		pessoaRepository.save(pessoa);
		return pessoa;
	}
}
