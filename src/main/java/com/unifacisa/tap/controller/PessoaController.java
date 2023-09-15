package com.unifacisa.tap.controller;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.unifacisa.tap.entity.Pessoa;
import com.unifacisa.tap.service.PessoaService;

@RestController
@RequestMapping("/api")
public class PessoaController {
	
	@Autowired
	PessoaService pessoaService;
	
	@GetMapping("/pessoas")
	public ResponseEntity<List<Pessoa>> listarPessoas() {	
		List<Pessoa> pessoas = pessoaService.listarTodasPessoas();
		return new ResponseEntity<List<Pessoa>>(pessoas, HttpStatus.OK);
	}
	
	@GetMapping("/pessoa/{id}")
	public ResponseEntity<Pessoa> getPessoa(@PathVariable int id) throws IOException {
		Pessoa pessoa = pessoaService.listarUsuarioPorId(id);
		return new ResponseEntity<Pessoa>(pessoa, HttpStatus.OK);
	}
	
	@GetMapping("/pessoa")
	public ResponseEntity<Pessoa> getPessoaByIdName(@RequestParam("id") int id, @RequestParam("nome") String nome) throws IOException {
	    Optional<Pessoa> pessoa = pessoaService.listarUsuarioPorIdNome(id, nome);
	    
	    if (pessoa.isPresent()) {
	        return new ResponseEntity<>(pessoa.get(), HttpStatus.OK);
	    } else {
	        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }
	}
	
	@PostMapping("/pessoas")
	public ResponseEntity<Pessoa> criarPessoa(@RequestBody Pessoa novaPessoa) {
		try {
			Pessoa pessoa = pessoaService.cadastrarPessoa(novaPessoa);
			return new ResponseEntity<Pessoa>(pessoa, HttpStatus.CREATED);

		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<Pessoa>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@DeleteMapping("/pessoa/{id}")
	public ResponseEntity<Pessoa> deletarPessoa(@PathVariable int id) {
		try {
			pessoaService.deletarPessoa(id);
			return new ResponseEntity<Pessoa>(HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<Pessoa>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PutMapping("/pessoa/{id}")
	public ResponseEntity<Pessoa> editarPessoa(@RequestBody Pessoa pessoa, @PathVariable int id) {
		try {
			pessoaService.editarPessoa(pessoa, id);
			return new ResponseEntity<Pessoa>(HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<Pessoa>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
