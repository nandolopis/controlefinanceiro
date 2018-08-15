package br.com.fernando.lopes.finance.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import br.com.fernando.lopes.finance.dto.CategoriaDTO;
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
	
	public List<Categoria> findAll(){
		return repo.findAll();
	}
	
	public Page<Categoria> findPage(Integer page, Integer linesPerPage, String orderBy, String direction ){
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		return repo.findAll(pageRequest);
	}
	
	/*
	 * Converte um objDto para obj comum 
	 */
	
	public Categoria fromDTO(CategoriaDTO objDto) {
		return new Categoria(objDto.getId(), objDto.getNome());
	}

}
