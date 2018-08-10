package br.com.fernando.lopes.finance.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fernando.lopes.finance.entities.Banco;
import br.com.fernando.lopes.finance.reposirories.BancoRepository;

@Service
public class BancoService {
	
	@Autowired
	private BancoRepository repo;
	
	public Banco find(Integer id) {
		Optional<Banco> obj = repo.findById(id);
		return obj.orElse(null);
	}

}
