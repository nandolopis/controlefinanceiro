package br.com.fernando.lopes.finance.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fernando.lopes.finance.entities.LancamentoCartao;
import br.com.fernando.lopes.finance.reposirories.LancamentoCartaoRepository;

@Service
public class LancamentoCartaoService {
	
	@Autowired
	private LancamentoCartaoRepository repo;
	
	public LancamentoCartao  find(Integer id) {
		Optional<LancamentoCartao> obj =  repo.findById(id);
		return obj.orElse(null);
	}

}
