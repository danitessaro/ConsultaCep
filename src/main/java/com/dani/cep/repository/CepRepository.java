package com.dani.cep.repository;


import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.dani.cep.entities.Cep;

@Repository
public interface CepRepository extends CrudRepository<Cep, Long> {
	
	Optional<Cep> findByCep(String cep);
	
	List<Cep> findAll();

}
