package br.com.fernando.lopes.finance.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import br.com.fernando.lopes.finance.dto.BancoDTO;
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
	
	public Banco insert(Banco obj) {
		obj.setId(null);
		return repo.save(obj);
	}
	
	public Banco update(Banco obj) {
		find(obj.getId());
		return repo.save(obj);
	}
	
	public void delete(Integer id) {
		try {
			find(id);
			repo.deleteById(id);
			
		} catch (DataIntegrityViolationException e) {
			
			throw new DataIntegrityViolationException("Não é possível Excluir uma Banco que possui lançamento");
			
		}
	}
	
	public List<Banco> findAll(){
		return repo.findAll();
	}
	
	public Page<Banco> findPage(Integer page, Integer linesPerPage, String orderBy, String direction ){
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		return repo.findAll(pageRequest);
	}
	
	/*
	 * Converte um objDto para obj comum 
	 */
	
	public Banco fromDTO(BancoDTO objDto) {
		return new Banco(objDto.getId(), objDto.getNome());
	}

}
