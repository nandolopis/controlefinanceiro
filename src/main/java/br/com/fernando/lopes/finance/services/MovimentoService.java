package br.com.fernando.lopes.finance.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fernando.lopes.finance.entities.Movimento;
import br.com.fernando.lopes.finance.reposirories.MovimentoRepository;

@Service
public class MovimentoService {
	
	@Autowired
	private MovimentoRepository repo;
	
	public Movimento find(Integer id) {
		Optional<Movimento> obj = repo.findById(id);
		return obj.orElse(null);
	}

}
