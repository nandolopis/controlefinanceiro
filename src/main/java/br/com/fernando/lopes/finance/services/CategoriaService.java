package br.com.fernando.lopes.finance.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import br.com.fernando.lopes.finance.entities.Categoria;
import br.com.fernando.lopes.finance.reposirories.CategoriaRepository;
import br.com.fernando.lopes.finance.services.exceptions.ObjectNotFoundException;

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
		
		if (obj == null) {
			throw new ObjectNotFoundException("Objeto não encontrado! Id: " + id
					+ ", Tipo: " + Categoria.class.getName());
		}
	
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
	
	public void delete(Integer id) {
		try {
			find(id);
			repo.deleteById(id);
			
		} catch (DataIntegrityViolationException e) {
			
			throw new DataIntegrityViolationException("Não é possível Excluir uma categoria que possui lançamento");
			
		}
	}

}
