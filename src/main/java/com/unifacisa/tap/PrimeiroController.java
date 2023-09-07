package com.unifacisa.tap;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import model.Pessoa;

@RestController
@RequestMapping("/api")
public class PrimeiroController {

	private List<Pessoa> pessoas = new ArrayList<>();
	
	@GetMapping("/pessoa")
	public List<Pessoa> listAll() {
//		Pessoa p = new Pessoa("esther", 18, "Rua Paris");
//		Pessoa b = new Pessoa("ruan", 29, "Rua Japão");
//		Pessoa c = new Pessoa("anne", 20, "Rua Europa");
//		
//		pessoas.add(c);
//		pessoas.add(b);
//		pessoas.add(p);
		
		return pessoas;
	}
	
	@GetMapping("/user/{nome}")
	public Pessoa getUser(@PathVariable String nome) {
//		if(nome == null) {
//			return new ResponseEntity<>(pessoas.stream().filter(p -> p.getNome().equals(nome)), HttpStatus.INTERNAL_SERVER_ERROR);
//		}else {
//			return new ResponseEntity<>(p, HttpStatus.CREATED);
//		}
		
//		new ResponseEntity<>(pessoas.stream().filter(p -> p.getNome().equals(nome)).findFirst(), HttpStatus.INTERNAL_SERVER_ERROR)
//		ResponseEntity res = new ResponseEntity<>()
//		return new ResponseEntity<>(pessoas.stream().filter(p -> p.getNome().equals(nome)).findFirst(), HttpStatus.CREATED).or;
		return pessoas.stream().filter(p -> p.getNome().equals(nome)).findFirst().orElse(null);
		
//		for (Pessoa p : pessoas) {
//			if(p.getNome().equals(nome)) {
//				return p;
//			}
//		}
//		return null;
	}
	
	@PostMapping("/teste")
	public ResponseEntity<Pessoa> addPessoa(@RequestBody Pessoa p) {
		if(p == null) {
			return new ResponseEntity<>(p, HttpStatus.INTERNAL_SERVER_ERROR);
		}else {
			pessoas.add(p);
			return new ResponseEntity<>(p, HttpStatus.CREATED);
		}
	}
}
