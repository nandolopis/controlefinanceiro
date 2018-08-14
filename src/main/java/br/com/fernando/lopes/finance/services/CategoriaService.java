package br.com.fernando.lopes.finance.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fernando.lopes.finance.entities.Categoria;
import br.com.fernando.lopes.finance.reposirories.CategoriaRepository;

@Service
public class CategoriaService {
	
	/*
	 * @Autowired vai ser automaticamente instanciada pelo spring 
	 */
	@Autowired
	private CategoriaRepository repo;
	
	public Categoria find(Integer id)  {
		
		//para evitar o problema do 'null pointer exception '
		Optional<Categoria> obj =  repo.findById(id); 
	
		return obj.orElse(null);
	}
	
	public Categoria insert(Categoria obj) {
		obj.setId(null);
		return repo.save(obj);
	}
	
	public Categoria update(Categoria obj) {
		find(obj.getId());
		return repo.save(obj);
	}

}
