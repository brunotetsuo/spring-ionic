package com.brunotetsuo.springionic.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.brunotetsuo.springionic.domain.Cliente;
import com.brunotetsuo.springionic.repositories.ClienteRepository;
import com.brunotetsuo.springionic.services.exceptions.ObjectNotFoundException;

@Service
public class ClienteService {

	@Autowired
	ClienteRepository repo;

	public Cliente buscar(Integer id) {
		Optional<Cliente> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Cliente.class.getName()));
	}
}