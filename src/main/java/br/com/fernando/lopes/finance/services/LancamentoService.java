package br.com.fernando.lopes.finance.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fernando.lopes.finance.entities.Lancamento;
import br.com.fernando.lopes.finance.reposirories.LancamentoRepository;

@Service
public class LancamentoService {
	
	@Autowired
	private LancamentoRepository repo;
	
	public Lancamento find(Integer id) {
		Optional<Lancamento> obj =  repo.findById(id);
		return obj.orElse(null);
	}

}
