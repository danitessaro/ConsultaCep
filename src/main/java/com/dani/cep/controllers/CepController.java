package com.dani.cep.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.dani.cep.entities.Cep;
import com.dani.cep.repository.CepRepository;

@RestController
public class CepController {

	private final CepRepository repository;
	
	CepController(CepRepository repository) {
		this.repository = repository;
	}
	
	@PostMapping("/cep")
	public Cep cadastrarCep(@RequestBody Cep cep) {
		return repository.save(cep);
	}
	
	@GetMapping("/cep/{cep}")
	public Optional<Cep> getCep(@PathVariable String cep) {
		return Optional.of(repository.findByCep(cep).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "CEP não encontrado")));
	}
	
	@GetMapping("/cep")
	public List<Cep> all() {
		return repository.findAll();
	}
}
