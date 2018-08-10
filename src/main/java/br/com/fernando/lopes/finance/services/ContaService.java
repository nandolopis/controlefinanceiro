package br.com.fernando.lopes.finance.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fernando.lopes.finance.entities.Conta;
import br.com.fernando.lopes.finance.reposirories.ContaRepository;

@Service
public class ContaService {
	
	@Autowired
	private ContaRepository repo;
	
	public Conta find(Integer id) {
		Optional<Conta> obj = repo.findById(id);
		return obj.orElse(null);
	}

}
