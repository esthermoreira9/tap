package com.unifacisa.tap;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import model.Pessoa;

@RestController
@RequestMapping("/api")
public class PrimeiroController {

	private List<Pessoa> pessoas = new ArrayList<>();
	
	@GetMapping("/pessoa")
	public List<Pessoa> listAll() {
		Pessoa p = new Pessoa("esther", 18, "Rua Paris");
		Pessoa b = new Pessoa("ruan", 29, "Rua Japão");
		Pessoa c = new Pessoa("anne", 20, "Rua Europa");
		
		pessoas.add(c);
		pessoas.add(b);
		pessoas.add(p);
		
		return pessoas;
	}

}
